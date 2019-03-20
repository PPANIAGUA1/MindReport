package com.mindreport.app.models.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindreport.app.models.entity.DatosFichero;
import com.mindreport.app.models.entity.Informe;
import com.mindreport.app.models.service.IinformeService;
import com.mindreport.app.models.service.IisssueService;
import com.mindreport.app.models.service.IworkLogService;
import java.util.List;

@RestController
public class IssuesController {
	

	@Autowired
	private IisssueService isssueService;
	
	@Autowired
	private IinformeService informeService;
	
	@Autowired
	private IworkLogService workLogService;
	
	final static Logger logger = LoggerFactory.getLogger(DatosFichero.class);

	
	 @PostMapping("/api")
	 @ResponseBody
	  public List<Informe> createReport(@RequestBody DatosFichero datosFichero) 
	 {
		workLogService.leerWorkLog(datosFichero.getRutaWorkLog());		
		isssueService.leerIssue(datosFichero.getRutaIssue());	
		List<Informe> informes = informeService.generarInforme();
		
	    return informes;
	 }
	
 }
