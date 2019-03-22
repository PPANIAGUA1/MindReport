package com.mindreport.app.models.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindreport.app.models.dao.IWorkLogDao;
import com.mindreport.app.models.dao.IissuesDao;
import com.mindreport.app.models.entity.Informe;
import com.mindreport.app.models.entity.Issues;
import com.mindreport.app.models.entity.WorkLog;

@Service
public class InformeServiceImpl implements IinformeService {
	
	@Autowired
	IWorkLogDao workLogDao;
	

	@Autowired
	IissuesDao issuesDao;
	
	final static Logger logger = LoggerFactory.getLogger(InformeServiceImpl.class);
	
	@Override
	@Transactional
	public List<Informe> generarInforme() 
	{
		List<Informe> informes = new ArrayList<Informe>();
		
		List<WorkLog> workLogs = (List<WorkLog>) workLogDao.findAll();
		for (WorkLog workLog:workLogs) {
			Informe informe = creaInforme(workLog);
			informes.add(informe);		
		}
	
		return informes;
	}
	
	
	private Informe creaInforme(WorkLog workLog) 
	{
		
		Informe informe= new Informe();
		Issues issues = workLog.getIssues();		
		
		informe.setIssueKey(workLog.getIssueKey());	
		informe.setComponent( workLog.getComponents());
		informe.setFullname(workLog.getFullName());
		informe.setHours(workLog.getHours());	
		informe.setLogin(workLog.getLogin());	
		informe.setProjectKey(workLog.getProjectKey());
		informe.setSummary(workLog.getSummary());
		informe.setVersion(workLog.getVersion());
		informe.setWorkdate(workLog.getWorkDate());
				
		int n =  workLog.getProjectKey().indexOf("-");
		
		if (n>1) 
			informe.setProjectGroup(workLog.getProjectKey().substring(1,n));
		else
			informe.setProjectGroup(workLog.getProjectKey());
		
		informe.setHoursByUserCalendar(new Double(0));
		
		informe.setIncurredDate(workLog.getCreated());	
		
		Date date= new Date(workLog.getCreated());
		SimpleDateFormat df = new SimpleDateFormat("MMM , ''yy");
		informe.setMonth (df.format(date).replace(" , '", ".-"));
		
		if (null == issues) {
			logger.info("no carga issue");
			issues = issuesDao.findById(workLog.getIssueKey()).get();
		}
		informe.setCreated(issues.getCreated());
		informe.setDueDate(issues.getDueDate());
		informe.setRealStartDate(issues.getRealStartDate());
		informe.setRealEndDate(issues.getRealEndDate());
		
		return informe;
	}

}
