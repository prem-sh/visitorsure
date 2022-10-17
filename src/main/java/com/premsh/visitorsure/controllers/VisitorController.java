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
import com.premsh.visitorsure.models.Visitor;
import com.premsh.visitorsure.services.api.AdminService;

@RestController
@RequestMapping("/visitor")
public class VisitorController {
	@Autowired Converter converter;
	@Autowired AdminService adminService;
	
	@GetMapping("/all")
	public ResponseEntity<String> getAllVisitors(){
		return new ResponseEntity<String>(converter.convert(adminService.listVisitors()), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> createVisitor(@RequestBody String visitor){
		Visitor v = converter.mapObject(visitor, Visitor.class);
		return new ResponseEntity<String>(converter.convert(adminService.createVisitor(v)), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> getVisitorById(@PathVariable Integer id){
		return new ResponseEntity<String>(converter.convert(adminService.getVisitorById(id)), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateVisitor(@RequestBody String visitor, @PathVariable Integer id){
		Visitor v = converter.mapObject(visitor, Visitor.class);
		return new ResponseEntity<String>(converter.convert(adminService.updateVisitorDetails(v, id)), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteVisitor(@PathVariable Integer id){
		return new ResponseEntity<String>(converter.convert(adminService.deleteVisitor(id)), HttpStatus.OK);
	}
}
