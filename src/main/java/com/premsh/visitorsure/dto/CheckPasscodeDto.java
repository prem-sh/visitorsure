package com.premsh.visitorsure.dto;

import com.premsh.visitorsure.models.Employee;
import com.premsh.visitorsure.models.Office;
import com.premsh.visitorsure.models.Visit;
import com.premsh.visitorsure.models.Visitor;

public class CheckPasscodeDto {
	
	private Employee employee;	
	private Office office;
	private Visitor visitor;
	private Visit visit;
	
	public Visit getVisit() {
		return visit;
	}
	public void setVisit(Visit visit) {
		this.visit = visit;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Office getOffice() {
		return office;
	}
	public void setOffice(Office office) {
		this.office = office;
	}
	public Visitor getVisitor() {
		return visitor;
	}
	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}
	
}
