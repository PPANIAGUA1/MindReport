package com.mindreport.app.models.service;

import java.util.List;

import com.mindreport.app.models.entity.Issues;

public interface IisssueService {

	public void save(List<Issues> issues);
	public List<Issues> findAll();
	public List<Issues> leerIssuesDeExcel(String fichero);
}
