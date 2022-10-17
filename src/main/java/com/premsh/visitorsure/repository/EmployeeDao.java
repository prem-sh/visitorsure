package com.premsh.visitorsure.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.premsh.visitorsure.models.Employee;

@Repository
public class EmployeeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private BeanPropertyRowMapper<Employee> employeeRowMapper = BeanPropertyRowMapper.newInstance(Employee.class);
	
	public List<Employee> getAllEmployees(){
		return jdbcTemplate.query("select * from employee", employeeRowMapper);
	}
	
	public List<Employee> getById(Integer id){
		return jdbcTemplate.query("select * from employee where employee_id=%d".formatted(id), employeeRowMapper);
	}
	
	public boolean createEmployee(final Employee employee) {
		
		return jdbcTemplate.execute("insert into employee(office_id, employee_id_internal, first_name, last_name, email, phone, profile_photo_url) values(?,?,?,?,?,?,?)",
				new PreparedStatementCallback<Boolean>(){  
		    public Boolean doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException, DataAccessException {  
		              
		    	ps.setInt(1, employee.getOfficeId()); 
		        ps.setString(2, employee.getEmployeeIdInternal()); 
		        ps.setString(3, employee.getFirstName()); 
		        ps.setString(4, employee.getLastName()); 
		        ps.setString(5, employee.getEmail()); 
		        ps.setString(6, employee.getPhone()); 
		        ps.setString(7, employee.getProfiePhotoUrl()); 
		              
		        return ps.execute();  
		              
		    }  
		    });  
		}  
	
	public boolean updateEmployee(final Employee employee, final Integer id) {
	
		
		return jdbcTemplate.execute("update employee set office_id=?, employee_id_internal=?, first_name =?, last_name=?, email=?, phone=?, profile_photo_url=? "
				+ "where employee_id = ?;", new PreparedStatementCallback<Boolean>() {
					
					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {

				    	ps.setInt(1, employee.getOfficeId()); 
				        ps.setString(2, employee.getEmployeeIdInternal()); 
				        ps.setString(3, employee.getFirstName()); 
				        ps.setString(4, employee.getLastName()); 
				        ps.setString(5, employee.getEmail()); 
				        ps.setString(6, employee.getPhone()); 
				        ps.setString(7, employee.getProfiePhotoUrl()); 
						ps.setInt(8, id);
						return ps.execute();
					}
				});
	}
	
	public boolean deleteEmployee(final Integer id) {
		return (jdbcTemplate.update("delete from employee where employee_id="+id+";") != 0);
	}
}
