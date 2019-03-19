package com.mindreport.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindreport.app.models.dao.IinformeDao;

@Service
public class InformeServiceImpl implements IinformeService {

	@Autowired
	private IinformeDao informeDao;
	
	@Override
	public void generarInforme(String fichero) {
		// TODO Auto-generated method stub
		
	}
	
}
