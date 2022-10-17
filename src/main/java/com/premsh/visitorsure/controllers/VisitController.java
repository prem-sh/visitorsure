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
import com.premsh.visitorsure.models.Visit;
import com.premsh.visitorsure.services.api.AdminService;

@RestController
@RequestMapping("/visit")
public class VisitController {
	@Autowired Converter converter;
	@Autowired AdminService adminService;
	
	@GetMapping("/all")
	public ResponseEntity<String> getAllVisits(){
		return new ResponseEntity<String>(converter.convert(adminService.listVisits()), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> createVisit(@RequestBody String visit){
		Visit v = converter.mapObject(visit, Visit.class);
		return new ResponseEntity<String>(converter.convert(adminService.scheduleVisit(v)), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> getVisitById(@PathVariable Integer id){
		return new ResponseEntity<String>(converter.convert(adminService.getVisitById(id)), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateVisit(@RequestBody String visit, @PathVariable Integer id){
		Visit v = converter.mapObject(visit, Visit.class);
		return new ResponseEntity<String>(converter.convert(adminService.updateVisitDetails(v, id)), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteVisit(@PathVariable Integer id){
		return new ResponseEntity<String>(converter.convert(adminService.cancelScheduledVisit(id)), HttpStatus.OK);
	}
}
