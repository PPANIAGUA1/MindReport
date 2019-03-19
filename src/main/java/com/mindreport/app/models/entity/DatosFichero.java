package com.mindreport.app.models.entity;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DatosFichero {
	
	 @JsonProperty("rutaIssue")
	 @NotBlank
	private String rutaIssue;
	
	 @JsonProperty("rutaWorkLog")
	 @NotBlank
	private String rutaWorkLog;

	public String getRutaIssue() {
		return rutaIssue;
	}

	public void setRutaIssue(String rutaIssue) {
		this.rutaIssue = rutaIssue;
	}

	public String getRutaWorkLog() {
		return rutaWorkLog;
	}

	public void setRutaWorkLog(String rutaWorkLog) {
		this.rutaWorkLog = rutaWorkLog;
	}

	
	
	
	

}
