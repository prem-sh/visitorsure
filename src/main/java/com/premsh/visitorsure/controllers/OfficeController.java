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
import com.premsh.visitorsure.models.Office;
import com.premsh.visitorsure.services.api.AdminService;

@RestController
@RequestMapping("/office")
public class OfficeController {
	

	@Autowired Converter converter;
	@Autowired AdminService adminService;
	
	@GetMapping("/all")
	public ResponseEntity<String> getAllOffices(){
		return new ResponseEntity<String>(converter.convert(adminService.listOffices()), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> createOffice(@RequestBody String office){
		Office o = converter.mapObject(office, Office.class);
		return new ResponseEntity<String>(converter.convert(adminService.createOffice(o)), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> getOfficeById(@PathVariable Integer id){
		return new ResponseEntity<String>(converter.convert(adminService.getOfficeById(id)), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> createOffice(@RequestBody String office, @PathVariable Integer id){
		Office o = converter.mapObject(office, Office.class);
		return new ResponseEntity<String>(converter.convert(adminService.updateOfficeDetails(o, id)), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOffice(@PathVariable Integer id){
		return new ResponseEntity<String>(converter.convert(adminService.deleteOffice(id)), HttpStatus.OK);
	}
}
