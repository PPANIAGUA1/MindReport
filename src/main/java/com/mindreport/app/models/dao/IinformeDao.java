package com.mindreport.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mindreport.app.models.entity.Informe;

public interface IinformeDao extends CrudRepository<Informe, String>{
	
//	@Query("select f from Factura f join fetch f.cliente c join fetch f.items l join fetch l.producto where f.id=?1")
//	public Informe generarInforme();

}
