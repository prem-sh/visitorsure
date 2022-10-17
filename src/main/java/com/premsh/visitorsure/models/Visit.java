package com.premsh.visitorsure.models;

import java.sql.Date;

public class Visit {
	private Integer visitId;
	private Integer visitorId;
	private Integer employeeId;
	private Integer officeId;
	private Date visitStartDate;
	private Date visitEndDate;
	private Integer passCode;
	
	
	public Integer getPassCode() {
		return passCode;
	}
	public void setPassCode(Integer passCode) {
		this.passCode = passCode;
	}
	public Integer getVisitId() {
		return visitId;
	}
	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}
	public Integer getVisitorId() {
		return visitorId;
	}
	public void setVisitorId(Integer visitorId) {
		this.visitorId = visitorId;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getOfficeId() {
		return officeId;
	}
	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}
	public Date getVisitStartDate() {
		return visitStartDate;
	}
	public void setVisitStartDate(Date visitStartDate) {
		this.visitStartDate = visitStartDate;
	}
	public Date getVisitEndDate() {
		return visitEndDate;
	}
	public void setVisitEndDate(Date visitEndDate) {
		this.visitEndDate = visitEndDate;
	}
	
	
}
