package com.premsh.visitorsure.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.premsh.visitorsure.models.Role;

@Repository
public class RoleTemplate {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Role> getAllRoles(){
		return jdbcTemplate.query("select * from user_role", new RowMapper<Role>() {
			public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Role(rs.getInt(1), rs.getString(3), rs.getString(3));
			}
		});
	}

}
