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
import com.premsh.visitorsure.models.Employee;
import com.premsh.visitorsure.services.api.AdminService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired Converter converter;
	@Autowired AdminService adminService;
	
	@GetMapping("/all")
	public ResponseEntity<String> getAllEmployees(){
		return new ResponseEntity<String>(converter.convert(adminService.listEmployees()), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> createEmployee(@RequestBody String employee){
		Employee e = converter.mapObject(employee, Employee.class);
		return new ResponseEntity<String>(converter.convert(adminService.createEmployee(e)), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> getEmployeeById(@PathVariable Integer id){
		return new ResponseEntity<String>(converter.convert(adminService.getEmployeeById(id)), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateEmployee(@RequestBody String employee, @PathVariable Integer id){
		Employee e = converter.mapObject(employee, Employee.class);
		return new ResponseEntity<String>(converter.convert(adminService.updateEmployeeDetails(e, id)), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
		return new ResponseEntity<String>(converter.convert(adminService.deleteEmployee(id)), HttpStatus.OK);
	}
}
