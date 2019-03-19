package com.mindreport.app.models.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public ResponseEntity<Informe> createReport(@Valid @RequestBody DatosFichero datosFichero) 
	{
	
		isssueService.leerIssue(datosFichero.getRutaIssue());	
		workLogService.leerWorkLog(datosFichero.getRutaWorkLog());
			
		List<Informe> informes = informeService.generarInforme();
		
		 return new ResponseEntity (informes, HttpStatus.CREATED);			
	}
	
	/* @RequestMapping(value = "/create", method = RequestMethod.POST)
	    public ResponseEntity<Informe> create(@Valid @RequestBody DatosFichero user) {
	    //    User userCreated = userService.create(user);
	     //   return new ResponseEntity(userCreated, HttpStatus.CREATED);
		 return null;
	    }
	*/

 }
