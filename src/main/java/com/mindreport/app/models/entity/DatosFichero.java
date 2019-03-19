package com.mindreport.app.models.entity;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DatosFichero {
	
	 @JsonProperty("ruta")
	 @NotBlank
	private String ruta;
	
	 @JsonProperty("tipo")
	 @NotBlank
	private String tipo;

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	

}
