package com.mindreport.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.mindreport.app.models.entity.WorkLog;

public interface IWorkLogDao extends CrudRepository<WorkLog, Long>{

}
