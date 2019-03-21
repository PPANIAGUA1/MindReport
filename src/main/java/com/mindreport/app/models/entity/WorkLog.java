package com.mindreport.app.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="workLog")
public class WorkLog {

	@Id
	private String issueKey;

	private Double hours;

	private String workDate;

	private String summary;

	private String login;

	private String fullName;

	private String status;

	private String issueType;

	private String projectKey;

	private String worklogDescription;

	private String phase ;
	
	private String version;
	
	private String components;
	
	private String parentIssueKey;
	
	private String created;
	
	private String keyClient;
	
	private String internalDesc;

	public String getIssueKey() {
		return issueKey;
	}

	public void setIssueKey(String issueKey) {
		this.issueKey = issueKey;
	}

	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getProjectKey() {
		return projectKey;
	}

	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}

	public String getWorklogDescription() {
		return worklogDescription;
	}

	public void setWorklogDescription(String worklogDescription) {
		this.worklogDescription = worklogDescription;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getComponents() {
		return components;
	}

	public void setComponents(String components) {
		this.components = components;
	}

	public String getParentIssueKey() {
		return parentIssueKey;
	}

	public void setParentIssueKey(String parentIssueKey) {
		this.parentIssueKey = parentIssueKey;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getKeyClient() {
		return keyClient;
	}

	public void setKeyClient(String keyClient) {
		this.keyClient = keyClient;
	}

	public String getInternalDesc() {
		return internalDesc;
	}

	public void setInternalDesc(String internalDesc) {
		this.internalDesc = internalDesc;
	}
	
}
