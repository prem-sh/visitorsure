package com.premsh.visitorsure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.premsh.visitorsure.models.Company;
import com.premsh.visitorsure.models.Employee;
import com.premsh.visitorsure.models.Office;
import com.premsh.visitorsure.models.Visit;
import com.premsh.visitorsure.models.Visitor;
import com.premsh.visitorsure.repository.CompanyDao;
import com.premsh.visitorsure.repository.EmployeeDao;
import com.premsh.visitorsure.repository.OfficeDao;
import com.premsh.visitorsure.repository.VisitDao;
import com.premsh.visitorsure.repository.VisitorDao;
import com.premsh.visitorsure.services.api.UserService;

@Service
public class UserServiceImpl extends VerifierServiceImpl implements UserService{
	@Autowired private VisitorDao visitorDao;
	@Autowired private EmployeeDao employeeDao;
	@Autowired private VisitDao visitDao;
	@Autowired private CompanyDao companyDao;
	@Autowired private OfficeDao offficDao;



	public List<Company> listCompanies() {

		return companyDao.getAllCompanies();
	}

	public boolean updateCompanyDetails(Company company, Integer id) {

		return companyDao.updateCompany(company, id);
	}

	public boolean deleteCompany(Integer companyId) {

		return companyDao.deleteCompany(companyId);
	}

	public boolean createCompany(Company company) {

		return companyDao.createCompany(company);
	}

	public List<Office> listOffices() {

		return offficDao.getAllCompanies();
	}

	public boolean updateOfficeDetails(Office office, Integer id) {

		return offficDao.updateOffice(office, id);
	}

	public boolean deleteOffice(Integer officeId) {

		return offficDao.deleteOffice(officeId);
	}

	public boolean createOffice(Office office) {

		return offficDao.createOffice(office);
	}

	public boolean updateEmployeeDetails(Employee employee, Integer id) {

		return employeeDao.updateEmployee(employee, id);
	}

	public boolean deleteEmployee(Integer employeeId) {

		return employeeDao.deleteEmployee(employeeId);
	}

	public boolean createEmployee(Employee employee) {

		return employeeDao.createEmployee(employee);
	}

	public boolean updateVisitorDetails(Visitor visitor, Integer id) {

		return visitorDao.updatevisitor(visitor, id);
	}

	public boolean deleteVisitor(Integer visitorId) {

		return visitorDao.deletevisitor(visitorId);
	}

	public boolean createVisitor(Visitor visitor) {

		return visitorDao.createvisitor(visitor);
	}

	public boolean updateVisitDetails(Visit visit, Integer id) {

		return visitDao.updateVisit(visit, id);
	}

	public boolean cancelScheduledVisit(Integer visitId) {

		return visitDao.deleteVisit(visitId);
	}

	public boolean scheduleVisit(Visit visit) {

		return visitDao.createVisit(visit);
	}
	

	public List<Visitor> listVisitors() {

		return visitorDao.getAllvisitors();
	}

	public List<Employee> listEmployees() {

		return employeeDao.getAllEmployees();
	}

	public List<Visit> listVisits() {

		return visitDao.getAllVisits();
	}

	public List<Company> getCompanyById(Integer id) {
		return companyDao.getById(id);
	}

	public List<Office> getOfficeById(Integer id) {
		return offficDao.getById(id);
	}

	public List<Employee> getEmployeeById(Integer id) {
		return employeeDao.getById(id);
	}

	public List<Visitor> getVisitorById(Integer id) {
		return visitorDao.getById(id);
	}

	public List<Visit> getVisitById(Integer id) {
		return visitDao.getById(id);
	}
	
	

}
