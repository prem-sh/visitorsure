package com.premsh.visitorsure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.premsh.visitorsure.component.Converter;
import com.premsh.visitorsure.models.User;
import com.premsh.visitorsure.repository.RoleDao;
import com.premsh.visitorsure.services.api.AdminService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired RoleDao roleDao;
	@Autowired Converter converter;
	@Autowired AdminService adminService;
	
	@GetMapping("/roles")
	public ResponseEntity<String> getRoles(){
		return new ResponseEntity<String>(converter.convert(roleDao.getAllRoles()), HttpStatus.OK);
	} 
	@GetMapping("/roles/{id}")
	public ResponseEntity<String> getRoleById(@PathVariable Integer id){
		return new ResponseEntity<String>(converter.convert(roleDao.getRoleById(id)), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<String> getAllUsers(){
		return new ResponseEntity<String>(converter.convert(adminService.listUsers()), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody String user){
		User u = converter.mapObject(user, User.class);
		return new ResponseEntity<String>(converter.convert(adminService.createUser(u)), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> getUserById(@PathVariable Integer id){
		return new ResponseEntity<String>(converter.convert(adminService.getUserbyId(id)), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> createUser(@RequestBody String user, @PathVariable Integer id){
		User u = converter.mapObject(user, User.class);
		return new ResponseEntity<String>(converter.convert(adminService.updateUserDetails(u, id)), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id){
		return new ResponseEntity<String>(converter.convert(adminService.deleteUser(id)), HttpStatus.OK);
	}
	
}
