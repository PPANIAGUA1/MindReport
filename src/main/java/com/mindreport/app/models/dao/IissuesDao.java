package com.mindreport.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.mindreport.app.models.entity.Issues;

public interface IissuesDao extends CrudRepository<Issues, String>{

}
