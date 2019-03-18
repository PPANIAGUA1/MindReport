package com.mindreport.app.models.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="workLog")
public class WorkLog {
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String issueKey;
	
	@NotEmpty
	private Long hours;
	
	@NotEmpty
	private Date workDate;
	
	@NotEmpty
	private String summary;
	
	@NotEmpty
	private String login;
	
	@NotEmpty
	private String fullName;
	
	@NotEmpty
	private String status;
	
	@NotEmpty
	private String issueType;
	
	@NotEmpty
	private String projectKey;
	
	@NotEmpty
	private String description;
	
	@NotEmpty
	private String phase ;
	
	private String version;
	
	private String components;
	
	private String parentIssueKey;
	
	private Date created;
	
	private String keyClient;
	
	private String internalDesc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIssueKey() {
		return issueKey;
	}

	public void setIssueKey(String issueKey) {
		this.issueKey = issueKey;
	}

	public Long getHours() {
		return hours;
	}

	public void setHours(Long hours) {
		this.hours = hours;
	}

	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
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
