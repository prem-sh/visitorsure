package com.premsh.visitorsure.services.api;

import java.util.List;

import com.premsh.visitorsure.models.Company;
import com.premsh.visitorsure.models.Employee;
import com.premsh.visitorsure.models.Office;
import com.premsh.visitorsure.models.Visit;
import com.premsh.visitorsure.models.Visitor;

public interface UserService extends VerifierServices {
	
	List<Company> listCompanies();
	List<Company> getCompanyById(Integer id);
	boolean updateCompanyDetails(Company company, Integer id);
	boolean deleteCompany(Integer companyId);
	boolean createCompany(Company company);
	
	List<Office> listOffices();
	List<Office> getOfficeById(Integer id);
	boolean updateOfficeDetails(Office office, Integer id);
	boolean deleteOffice(Integer officeId);
	boolean createOffice(Office office);


	List<Employee> listEmployees();
	List<Employee> getEmployeeById(Integer id);
	boolean updateEmployeeDetails(Employee employee, Integer id);
	boolean deleteEmployee(Integer employeeId);
	boolean createEmployee(Employee employee);

	List<Visitor> listVisitors();
	List<Visitor> getVisitorById(Integer id);
	boolean updateVisitorDetails(Visitor visitor, Integer id);
	boolean deleteVisitor(Integer visitorId);
	boolean createVisitor(Visitor visitor);

	List<Visit> listVisits();
	List<Visit> getVisitById(Integer id);
	boolean updateVisitDetails(Visit visit, Integer id);
	boolean cancelScheduledVisit(Integer visitId);
	boolean scheduleVisit(Visit visit);

}
