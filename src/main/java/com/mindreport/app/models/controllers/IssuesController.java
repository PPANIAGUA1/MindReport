package com.mindreport.app.models.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindreport.app.models.service.IisssueService;
import com.mindreport.app.models.service.IworkLogService;


@Controller
@RequestMapping("/api/issues")
public class IssuesController {
	

	@Autowired
	private IisssueService isssueService;
	
	@Autowired
	private IworkLogService workLogService;

	@RequestMapping(value = "/{ruta}/{tipo}", method = RequestMethod.GET)
	public void ver(@PathVariable(value = "ruta") String ruta,@PathVariable(value = "tipo") String tipo) {

		if ("issue".equals(tipo)) {
			isssueService.leerIssue(ruta);
		}else {
			workLogService.leerWorkLog(ruta);
		}
	
		
	}
	
}
