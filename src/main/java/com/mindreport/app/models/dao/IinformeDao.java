package com.mindreport.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mindreport.app.models.entity.Informe;

public interface IinformeDao extends CrudRepository<Informe, String>{
	
	
	//@Query("SELECT * FROM ISSUES i join WORK_LOG w on i.issue_Key=w.ISSUE_KEY")	
	//public List<Informe> generarInforme();
	
	

}
