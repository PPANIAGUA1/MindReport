package com.mindreport.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mindreport.app.models.entity.Informe;
import com.mindreport.app.models.entity.WorkLog;

public interface IWorkLogDao extends CrudRepository<WorkLog, Long>{
	
	@Query("select w from WorkLog w where w.issueKey like %?1%")
	public List<WorkLog> findByIssue(String issueKey);
	
	@Query("select w from WorkLog w join Issues i on w.issueKey= i.issueKey")	
	public List<WorkLog> generarInforme();

}
