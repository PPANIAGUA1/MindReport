package com.mindreport.app.models.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindreport.app.models.dao.IinformeDao;
import com.mindreport.app.models.entity.Informe;

@Service
public class InformeServiceImpl implements IinformeService {

	@Autowired
	private IinformeDao informeDao;
	
	@Override
	@Transactional
	public List<Informe> generarInforme() 
	{
		Informe informe = new Informe();
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
		
		informes.add(informe);
		return informes;
	}
	
	
	public Informe generarInforme2() 
	{
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
				
		return informe;
		
	}


}
