package com.mindreport.app.models.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindreport.app.models.entity.DatosFichero;
import com.mindreport.app.models.service.IisssueService;
import com.mindreport.app.models.service.IworkLogService;


@RestController
public class IssuesController {
	

	@Autowired
	private IisssueService isssueService;
	
	//private DatosFichero datosFichero;
	
	@Autowired
	private IworkLogService workLogService;
	
	final static Logger logger = LoggerFactory.getLogger(DatosFichero.class);

	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public void ver(@RequestBody DatosFichero datosFichero) 
	{
		logger.info("El tipo es: ".concat(datosFichero.getTipo()));
		logger.info("La ruta es: ".concat(datosFichero.getRuta()));
		if ("issue".equals(datosFichero.getTipo())) {
			isssueService.leerIssue(datosFichero.getRuta());
		}else {
			workLogService.leerWorkLog(datosFichero.getRuta());
		}
	
	}
	
	/* @RequestMapping(value = "/create", method = RequestMethod.POST)
	    public ResponseEntity<DatosFichero> create(@Valid @RequestBody DatosFichero user) {
	    //    User userCreated = userService.create(user);
	     //   return new ResponseEntity(userCreated, HttpStatus.CREATED);
		 return null;
	    }
	*/

 }
