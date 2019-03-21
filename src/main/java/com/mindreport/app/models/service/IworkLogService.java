package com.mindreport.app.models.service;

import java.util.List;

import com.mindreport.app.models.entity.WorkLog;

public interface IworkLogService {

	public void save(List<WorkLog> workLogs);
	public List<WorkLog> leerWorkLogDeExcel(String fichero);
}
