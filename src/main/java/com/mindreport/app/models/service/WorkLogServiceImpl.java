package com.mindreport.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindreport.app.models.dao.IWorkLogDao;
import com.mindreport.app.models.entity.WorkLog;

public class WorkLogServiceImpl implements IworkLogService{

	@Autowired
	private IWorkLogDao workLogDao;
	
	@Override
	public void leerWorkLog(String fichero) {
		
		WorkLog workLog = crearWorkLog(fichero);
		workLogDao.save(workLog);
		
	}

	private WorkLog crearWorkLog(String fichero) {
		// TODO Auto-generated method stub
		return null;
	}

}
