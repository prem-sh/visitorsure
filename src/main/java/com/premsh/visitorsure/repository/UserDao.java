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

import com.premsh.visitorsure.models.User;
//TODO Handle exceptions 		

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private BeanPropertyRowMapper<User> userRowMapper = BeanPropertyRowMapper.newInstance(User.class);
	
	public List<User> getAllUsers(){
		return jdbcTemplate.query("select * from user", userRowMapper);
	}
	
	public List<User> getUser(Integer id){
		return jdbcTemplate.query("select * from user where user_id=%d".formatted(id), userRowMapper);
	}
	
	public boolean createUser(final User user) {
		
		return jdbcTemplate.execute("insert into user(first_name, last_name, email, phone, profile_photo_url, role_id) values(?,?,?,?,?,?)",
				new PreparedStatementCallback<Boolean>(){  
		    public Boolean doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException, DataAccessException {  
		              
		        ps.setString(1, user.getFirstName()); 
		        ps.setString(2, user.getLastName()); 
		        ps.setString(3, user.getEmail()); 
		        ps.setString(4, user.getPhone()); 
		        ps.setString(5, user.getProfiePhotoUrl()); 
		        ps.setInt(6, user.getRoleId()); 
		              
		        return ps.execute();  
		              
		    }  
		    });  
		}  
	
	public boolean updateUser(final User user, final Integer id) {
		
		return jdbcTemplate.execute("update user set first_name =?, last_name=?, email=?, phone=?, profile_photo_url=?, role_id=? "
				+ "where user_id = ?;", new PreparedStatementCallback<Boolean>() {
					
					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {

						
						ps.setString(1, user.getFirstName());
						ps.setString(2, user.getLastName());
						ps.setString(3, user.getEmail());
						ps.setString(4, user.getPhone());
						ps.setString(5, user.getProfiePhotoUrl());
						ps.setInt(6, user.getRoleId());
						ps.setInt(7, id);
						return ps.execute();
					}
				});
	}
	
	public boolean deleteUser(final Integer id) {
		return (jdbcTemplate.update("delete from user where user_id="+id+";") != 0);
	}

}
