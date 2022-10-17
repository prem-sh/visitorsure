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

import com.premsh.visitorsure.models.Company;

@Repository
public class CompanyDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private BeanPropertyRowMapper<Company> companyRowMapper = BeanPropertyRowMapper.newInstance(Company.class);
	
	public List<Company> getAllCompanies(){
		return jdbcTemplate.query("select * from company", companyRowMapper);
	}
	
	public List<Company> getById(Integer id){
		return jdbcTemplate.query("select * from company where company_id=%d".formatted(id), companyRowMapper);
	}
	
	public boolean createCompany(final Company company) {
		
		return jdbcTemplate.execute("insert into company(company_name, email, phone) values(?,?,?)",
				new PreparedStatementCallback<Boolean>(){  
		    public Boolean doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException, DataAccessException {  
		              
		        ps.setString(1, company.getCompanyName()); 
		        ps.setString(2, company.getEmail()); 
		        ps.setString(3, company.getPhone()); 
		         
		        return ps.execute();  
		              
		    }  
		    });  
		}  
	
	public boolean updateCompany(final Company company, final Integer id) {
		
		
		return jdbcTemplate.execute("update company set company_name=?, email=?, phone=? "
				+ "where company_id = ?;", new PreparedStatementCallback<Boolean>() {
					
					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {

				
				        ps.setString(1, company.getCompanyName()); 
				        ps.setString(2, company.getEmail()); 
				        ps.setString(3, company.getPhone()); 
						ps.setInt(4, id);
						return ps.execute();
					}
				});
	}
	
	public boolean deleteCompany(final Integer id) {
		return (jdbcTemplate.update("delete from company where company_id="+id+";") != 0);
	}
}
