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

import com.premsh.visitorsure.models.Office;

@Repository
public class OfficeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private BeanPropertyRowMapper<Office> officeRowMapper = BeanPropertyRowMapper.newInstance(Office.class);
	
	public List<Office> getAllCompanies(){
		return jdbcTemplate.query("select * from office", officeRowMapper);
	}
	public List<Office> getById(Integer id){
		return jdbcTemplate.query("select * from office where office_id=%d".formatted(id), officeRowMapper);
	}
	
	public boolean createOffice(final Office office) {
		
		return jdbcTemplate.execute("insert into office(company_id, phone, address, email) values(?,?,?,?)",
				new PreparedStatementCallback<Boolean>(){  
		    public Boolean doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException, DataAccessException {  
		              
		        ps.setInt(1, office.getCompanyId()); 
		        ps.setString(2, office.getPhone()); 
		        ps.setString(3, office.getAddress()); 
		        ps.setString(4, office.getEmail()); 
		         
		        return ps.execute();  
		              
		    }  
		    });  
		}  
	
	public boolean updateOffice(final Office office, final Integer id) {
		
		
		return jdbcTemplate.execute("update office set company_id=?, phone=?, address=?, email=? "
				+ "where office_id = ?;", new PreparedStatementCallback<Boolean>() {
					
					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {

				        ps.setInt(1, office.getCompanyId()); 
				        ps.setString(2, office.getPhone()); 
				        ps.setString(3, office.getAddress()); 
				        ps.setString(4, office.getEmail()); 
						ps.setInt(5, id);
						return ps.execute();
					}
				});
	}
	
	public boolean deleteOffice(final Integer id) {
		return (jdbcTemplate.update("delete from office where office_id="+id+";") != 0);
	}
}
