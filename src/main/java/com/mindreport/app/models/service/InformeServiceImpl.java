package com.mindreport.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindreport.app.models.dao.IinformeDao;
import com.mindreport.app.models.entity.Informe;

@Service
public class InformeServiceImpl implements IinformeService {

	@Autowired
	private IinformeDao informeDao;
	
	@Override
	public List<Informe> generarInforme() {
		return null;
		
	}
	
}
