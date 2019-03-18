package com.mindreport.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindreport.app.models.dao.IissuesDao;

public class IsssueServiceImpl implements IisssueService{

	@Autowired
	private IissuesDao issuesDao;
	
	@Override
	public void leerIssue(String fichero) {
		// TODO Auto-generated method stub
				
	}

}
