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
import com.premsh.visitorsure.models.Company;
import com.premsh.visitorsure.services.api.AdminService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired Converter converter;
	@Autowired AdminService adminService;
	
	@GetMapping("/all")
	public ResponseEntity<String> getAllCompanies(){
		return new ResponseEntity<String>(converter.convert(adminService.listCompanies()), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> createCompany(@RequestBody String company){
		Company c = converter.mapObject(company, Company.class);
		return new ResponseEntity<String>(converter.convert(adminService.createCompany(c)), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> getCompanyById(@PathVariable Integer id){
		return new ResponseEntity<String>(converter.convert(adminService.getCompanyById(id)), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@RequestBody String company, @PathVariable Integer id){
		Company c = converter.mapObject(company, Company.class);
		return new ResponseEntity<String>(converter.convert(adminService.updateCompanyDetails(c, id)), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Integer id){
		return new ResponseEntity<String>(converter.convert(adminService.deleteCompany(id)), HttpStatus.OK);
	}
}
