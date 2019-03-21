package com.mindreport.app.models.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.standard.InstantFormatter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindreport.app.models.dao.IWorkLogDao;
import com.mindreport.app.models.dao.IinformeDao;
import com.mindreport.app.models.dao.IissuesDao;
import com.mindreport.app.models.entity.Informe;
import com.mindreport.app.models.entity.Issues;
import com.mindreport.app.models.entity.WorkLog;

@Service
public class InformeServiceImpl implements IinformeService {

	@Autowired
	private IinformeDao informeDao;
	
	@Autowired
	IWorkLogDao workLogDao;
	

	@Autowired
	IissuesDao issuesDao;
	
	@Override
	@Transactional
	public List<Informe> generarInforme() 
	{
		List<Informe> informes = new ArrayList<Informe>();
		
	//	List<WorkLog> workLogs = workLogDao.generarInforme();
		List<WorkLog> workLogs = (List<WorkLog>) workLogDao.findAll();
		for (WorkLog workLog:workLogs) {
			Informe informe = creaInforme(workLog);
			informes.add(informe);		
		}
	
		
	//	informes = informeDao.generarInforme();
		
	/*	Informe informe = new Informe();
		List<Informe> informes = new ArrayList<Informe>();
		
		informe.setIssueKey("SIOPMN-24374");
		informe.setHours(new Double(9));
		informe.setWorkdate(new Date());
		informe.setIncurredDate(new Date());
		informe.setSummary("NEGOCIA_System_Tests_Inclusión de tooltip");
		informe.setLogin("aacornejo");
		informe.setFullname("aacornejo0000");
		informe.setProjectKey("SIOPMN");
		informe.setVersion("SIOPMN_Backlog_Evolutivo,SIOPMN_Base_Evolutivo");
		informe.setComponent("ASEGURA");
		informe.setLocation("Malaga");
		informe.setHoursByUserCalendar(new Double(0));
		informe.setProjectGroup("SIOPMN");
		informe.setMonth("mar.-19");
		
		informeDao.save(informe);
		
		informes.add(informe);*/
		return informes;
	}
	
	
	private Informe creaInforme(WorkLog workLog) 
	{
		Issues issues = issuesDao.findById(workLog.getIssueKey()).get();
		
		Informe informe= new Informe();
		
		informe.setComponent( workLog.getComponents());
		informe.setFullname(workLog.getFullName());
		informe.setHours(workLog.getHours());		
		informe.setIssueKey(workLog.getIssueKey());		
		informe.setLogin(workLog.getLogin());	
		informe.setProjectKey(workLog.getProjectKey());
		informe.setSummary(workLog.getSummary());
		informe.setVersion(workLog.getVersion());
		informe.setWorkdate(workLog.getWorkDate());
	/*	
		informe.setHoursByUserCalendar(issues.getH
		informe.setIncurredDate(issues.getincu
		informe.setLocation(issues.getLoc);
		informe.setMonth(issues.getMo);
		informe.setProjectGroup(issues.getProjectG);
		*/
				
		
		return informe;
	}


	/*public List<Informe> generarInforme2() 
	{
		List<Informe> informes = new ArrayList<Informe>();
		Informe informe = new Informe();
	
		informe.setIssueKey("SIOPMN-24374");
		informe.setHours(new Double(9));
		informe.setWorkdate(new Date());
		informe.setIncurredDate(new Date());
		informe.setSummary("NEGOCIA_System_Tests_Inclusión de tooltip");
		informe.setLogin("aacornejo");
		informe.setFullname("aacornejo0000");
		informe.setProjectKey("SIOPMN");
		informe.setVersion("SIOPMN_Backlog_Evolutivo,SIOPMN_Base_Evolutivo");
		informe.setComponent("ASEGURA");
		informe.setLocation("Malaga");
		informe.setHoursByUserCalendar(new Double(0));
		informe.setProjectGroup("SIOPMN");
		informe.setMonth("mar.-19");
		informeDao.save(informe);
		informes.add(informe);
		return informes;
		
	}*/


}
