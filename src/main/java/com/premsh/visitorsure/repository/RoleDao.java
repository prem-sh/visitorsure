package com.premsh.visitorsure.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.premsh.visitorsure.models.Role;

@Repository
public class RoleDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private BeanPropertyRowMapper<Role> roleRowMapper = BeanPropertyRowMapper.newInstance(Role.class);

	public List<Role> getAllRoles(){
		return jdbcTemplate.query("select * from user_role", roleRowMapper);
	}
	
	public List<Role> getRoleById(Integer id) {
		return jdbcTemplate.query("select * from user_role where role_id=%d".formatted(id), roleRowMapper);
	}
}
