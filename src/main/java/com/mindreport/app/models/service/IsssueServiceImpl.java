package com.mindreport.app.models.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindreport.app.models.dao.IissuesDao;
import com.mindreport.app.models.entity.DatosFichero;
import com.mindreport.app.models.entity.Issues;

@Service
public class IsssueServiceImpl implements IisssueService{

	@Autowired
	private IissuesDao issuesDao;
	
	final static Logger logger = LoggerFactory.getLogger(DatosFichero.class);
	
	@Override
	public void leerIssue(String fichero) {
		logger.info("El fichero es: ".concat(fichero));
		Issues issues = generarExcelIssues(fichero);
		issuesDao.save(issues);
	}

	private Issues generarExcelIssues(String fichero)
	{
		Issues issues = new Issues();
		
		
		
		return issues;
	}

}
