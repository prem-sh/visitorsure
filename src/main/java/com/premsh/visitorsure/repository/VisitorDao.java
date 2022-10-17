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

import com.premsh.visitorsure.models.Visitor;

@Repository
public class VisitorDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private BeanPropertyRowMapper<Visitor> visitorRowMapper = BeanPropertyRowMapper.newInstance(Visitor.class);
	
	public List<Visitor> getAllvisitors(){
		return jdbcTemplate.query("select * from visitor", visitorRowMapper);
	}
	public List<Visitor> getById(Integer id){
		return jdbcTemplate.query("select * from visitor where visitor_id=%d".formatted(id), visitorRowMapper);
	}
	
	public boolean createvisitor(final Visitor visitor) {
		
		return jdbcTemplate.execute("insert into visitor(first_name, last_name, email, phone, profile_photo_url) values(?,?,?,?,?)",
				new PreparedStatementCallback<Boolean>(){  
		    public Boolean doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException, DataAccessException {  
		              
		        ps.setString(1, visitor.getFirstName()); 
		        ps.setString(2, visitor.getLastName()); 
		        ps.setString(3, visitor.getEmail()); 
		        ps.setString(4, visitor.getPhone()); 
		        ps.setString(5, visitor.getProfiePhotoUrl()); 
		        return ps.execute();  
		    }  
		    });  
		}  
	
	public boolean updatevisitor(final Visitor visitor, final Integer id) {
		
		return jdbcTemplate.execute("update visitor set first_name =?, last_name=?, email=?, phone=?, profile_photo_url=? "
				+ "where visitor_id = ?;", new PreparedStatementCallback<Boolean>() {
					
					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {

						
						ps.setString(1, visitor.getFirstName());
						ps.setString(2, visitor.getLastName());
						ps.setString(3, visitor.getEmail());
						ps.setString(4, visitor.getPhone());
						ps.setString(5, visitor.getProfiePhotoUrl());
						ps.setInt(6, id);
						return ps.execute();
					}
				});
	}
	
	public boolean deletevisitor(final Integer id) {
		return (jdbcTemplate.update("delete from visitor where visitor_id="+id+";") != 0);
	}

}
