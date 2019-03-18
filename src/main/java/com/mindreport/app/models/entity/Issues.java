package com.mindreport.app.models.entity;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="issues")
public class Issues {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String issueKey;

	@OneToMany (fetch = FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="issueKey")
	private List<WorkLog> workLogs; 
	
	@NotEmpty
	private String issueType;
	
	@NotEmpty
	private String priority;
	
	@NotEmpty
	private String summary;
	
	@NotEmpty
	private String assignee;
	
	@NotEmpty
	private String reporter;
	
	private String fixVersions;
	
	private String components;
	
	private Double customEstimate;
		
	private Long originalEstimate;
	
	private Long timeSpent;
	
	private Long remainingEstimate;
	
	private Long progress;
	
	@NotEmpty
	private Date created;
	
	
	private Date updated;
	
	@NotEmpty
	private String status;
	
	private Timestamp plannedEndDate;
	
	private String spring;
	
	private String resolution;
	
	@NotEmpty
	private Date realStartDate;
	
	private Date realEndDate;
	
	private Timestamp resolved;
	
	@NotEmpty
	private Integer rank;
	
	private String gepProject;
	
	private String labels;
		
	private String  storyPoints;
	
	private String projectParameter1;
	
	private String projectParameter2;
	
	private String projectParameter3;
	
	private String projectParameter4;
	
	private String projectParameter5;
	
	private String projectParameter6;
	
	private String projectParameter7;
	
	private String projectParameter8;
	
	private String projectParameter9;
	
	private String projectParameter10;
	
	private String affectsVersions;
	
	@NotEmpty
	private String projectKey;
	
	private String parentIssueKey;
	
	private String parentIssueSummary;
	
	private String keyClient;
	
	@NotEmpty
	private Timestamp plannedStartedDate;
		
	private Double totalEstimateHours;
	
	private Timestamp plannedStartedDateInitial;

	private Timestamp plannedEndDateInitial;
	
	@NotEmpty
	private Long TotalOriginalEstimate;
	
	@NotEmpty
	private Long TotalTimeSpent;
	
	@NotEmpty
	private Long TotalRemainingEstimate;
	
	private String StopReasons;
	
	private Date estimationDeliveryCommitment;
	
	private Date planningDeliveryCommitment;
	
	private String rework;
	
	private String soldUnits;	
	
	private String projectParameter11;
	
	private String projectParameter12;
	
	private String externalIssueId;

	public String getIssueKey() {
		return issueKey;
	}

	public void setIssueKey(String issueKey) {
		this.issueKey = issueKey;
	}

	public List<WorkLog> getWorkLogs() {
		return workLogs;
	}

	public void setWorkLogs(List<WorkLog> workLogs) {
		this.workLogs = workLogs;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getFixVersions() {
		return fixVersions;
	}

	public void setFixVersions(String fixVersions) {
		this.fixVersions = fixVersions;
	}

	public String getComponents() {
		return components;
	}

	public void setComponents(String components) {
		this.components = components;
	}

	public Double getCustomEstimate() {
		return customEstimate;
	}

	public void setCustomEstimate(Double customEstimate) {
		this.customEstimate = customEstimate;
	}

	public Long getOriginalEstimate() {
		return originalEstimate;
	}

	public void setOriginalEstimate(Long originalEstimate) {
		this.originalEstimate = originalEstimate;
	}

	public Long getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(Long timeSpent) {
		this.timeSpent = timeSpent;
	}

	public Long getRemainingEstimate() {
		return remainingEstimate;
	}

	public void setRemainingEstimate(Long remainingEstimate) {
		this.remainingEstimate = remainingEstimate;
	}

	public Long getProgress() {
		return progress;
	}

	public void setProgress(Long progress) {
		this.progress = progress;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getPlannedEndDate() {
		return plannedEndDate;
	}

	public void setPlannedEndDate(Timestamp plannedEndDate) {
		this.plannedEndDate = plannedEndDate;
	}

	public String getSpring() {
		return spring;
	}

	public void setSpring(String spring) {
		this.spring = spring;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Date getRealStartDate() {
		return realStartDate;
	}

	public void setRealStartDate(Date realStartDate) {
		this.realStartDate = realStartDate;
	}

	public Date getRealEndDate() {
		return realEndDate;
	}

	public void setRealEndDate(Date realEndDate) {
		this.realEndDate = realEndDate;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getGepProject() {
		return gepProject;
	}

	public void setGepProject(String gepProject) {
		this.gepProject = gepProject;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getStoryPoints() {
		return storyPoints;
	}

	public void setStoryPoints(String storyPoints) {
		this.storyPoints = storyPoints;
	}

	public String getProjectParameter1() {
		return projectParameter1;
	}

	public void setProjectParameter1(String projectParameter1) {
		this.projectParameter1 = projectParameter1;
	}

	public String getProjectParameter2() {
		return projectParameter2;
	}

	public void setProjectParameter2(String projectParameter2) {
		this.projectParameter2 = projectParameter2;
	}

	public String getProjectParameter3() {
		return projectParameter3;
	}

	public void setProjectParameter3(String projectParameter3) {
		this.projectParameter3 = projectParameter3;
	}

	public String getProjectParameter4() {
		return projectParameter4;
	}

	public void setProjectParameter4(String projectParameter4) {
		this.projectParameter4 = projectParameter4;
	}

	public String getProjectParameter5() {
		return projectParameter5;
	}

	public void setProjectParameter5(String projectParameter5) {
		this.projectParameter5 = projectParameter5;
	}

	public String getProjectParameter6() {
		return projectParameter6;
	}

	public void setProjectParameter6(String projectParameter6) {
		this.projectParameter6 = projectParameter6;
	}

	public String getProjectParameter7() {
		return projectParameter7;
	}

	public void setProjectParameter7(String projectParameter7) {
		this.projectParameter7 = projectParameter7;
	}

	public String getProjectParameter8() {
		return projectParameter8;
	}

	public void setProjectParameter8(String projectParameter8) {
		this.projectParameter8 = projectParameter8;
	}

	public String getProjectParameter9() {
		return projectParameter9;
	}

	public void setProjectParameter9(String projectParameter9) {
		this.projectParameter9 = projectParameter9;
	}

	public String getProjectParameter10() {
		return projectParameter10;
	}

	public void setProjectParameter10(String projectParameter10) {
		this.projectParameter10 = projectParameter10;
	}

	public String getAffectsVersions() {
		return affectsVersions;
	}

	public void setAffectsVersions(String affectsVersions) {
		this.affectsVersions = affectsVersions;
	}

	public String getProjectKey() {
		return projectKey;
	}

	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}

	public String getParentIssueKey() {
		return parentIssueKey;
	}

	public void setParentIssueKey(String parentIssueKey) {
		this.parentIssueKey = parentIssueKey;
	}

	public String getParentIssueSummary() {
		return parentIssueSummary;
	}

	public void setParentIssueSummary(String parentIssueSummary) {
		this.parentIssueSummary = parentIssueSummary;
	}

	public String getKeyClient() {
		return keyClient;
	}

	public void setKeyClient(String keyClient) {
		this.keyClient = keyClient;
	}

	public Timestamp getPlannedStartedDate() {
		return plannedStartedDate;
	}

	public void setPlannedStartedDate(Timestamp plannedStartedDate) {
		this.plannedStartedDate = plannedStartedDate;
	}

	public Double getTotalEstimateHours() {
		return totalEstimateHours;
	}

	public void setTotalEstimateHours(Double totalEstimateHours) {
		this.totalEstimateHours = totalEstimateHours;
	}

	public Timestamp getPlannedStartedDateInitial() {
		return plannedStartedDateInitial;
	}

	public void setPlannedStartedDateInitial(Timestamp plannedStartedDateInitial) {
		this.plannedStartedDateInitial = plannedStartedDateInitial;
	}

	public Timestamp getPlannedEndDateInitial() {
		return plannedEndDateInitial;
	}

	public void setPlannedEndDateInitial(Timestamp plannedEndDateInitial) {
		this.plannedEndDateInitial = plannedEndDateInitial;
	}

	public Long getTotalOriginalEstimate() {
		return TotalOriginalEstimate;
	}

	public void setTotalOriginalEstimate(Long totalOriginalEstimate) {
		TotalOriginalEstimate = totalOriginalEstimate;
	}

	public Long getTotalTimeSpent() {
		return TotalTimeSpent;
	}

	public void setTotalTimeSpent(Long totalTimeSpent) {
		TotalTimeSpent = totalTimeSpent;
	}

	public Long getTotalRemainingEstimate() {
		return TotalRemainingEstimate;
	}

	public void setTotalRemainingEstimate(Long totalRemainingEstimate) {
		TotalRemainingEstimate = totalRemainingEstimate;
	}

	public String getStopReasons() {
		return StopReasons;
	}

	public void setStopReasons(String stopReasons) {
		StopReasons = stopReasons;
	}

	public Date getEstimationDeliveryCommitment() {
		return estimationDeliveryCommitment;
	}

	public void setEstimationDeliveryCommitment(Date estimationDeliveryCommitment) {
		this.estimationDeliveryCommitment = estimationDeliveryCommitment;
	}

	public Date getPlanningDeliveryCommitment() {
		return planningDeliveryCommitment;
	}

	public void setPlanningDeliveryCommitment(Date planningDeliveryCommitment) {
		this.planningDeliveryCommitment = planningDeliveryCommitment;
	}

	public String getRework() {
		return rework;
	}

	public void setRework(String rework) {
		this.rework = rework;
	}

	public String getSoldUnits() {
		return soldUnits;
	}

	public void setSoldUnits(String soldUnits) {
		this.soldUnits = soldUnits;
	}

	public String getProjectParameter11() {
		return projectParameter11;
	}

	public void setProjectParameter11(String projectParameter11) {
		this.projectParameter11 = projectParameter11;
	}

	public String getProjectParameter12() {
		return projectParameter12;
	}

	public void setProjectParameter12(String projectParameter12) {
		this.projectParameter12 = projectParameter12;
	}

	public String getExternalIssueId() {
		return externalIssueId;
	}

	public void setExternalIssueId(String externalIssueId) {
		this.externalIssueId = externalIssueId;
	}
	
	
}
