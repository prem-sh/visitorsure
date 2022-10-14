package com.premsh.visitorsure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.premsh.visitorsure.component.Converter;
import com.premsh.visitorsure.repository.RoleTemplate;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired RoleTemplate roleTemplate;
	@Autowired Converter converter;
	
	@GetMapping("/roles")
	public ResponseEntity<String> getRoles(){
		return new ResponseEntity<String>(converter.convert(roleTemplate.getAllRoles()), HttpStatus.OK);
	} 
}
