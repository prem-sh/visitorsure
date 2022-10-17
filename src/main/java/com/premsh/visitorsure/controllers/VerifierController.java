package com.premsh.visitorsure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.premsh.visitorsure.component.Converter;
import com.premsh.visitorsure.services.api.VerifierServices;

@RestController
@RequestMapping("/verifier")
public class VerifierController {
	@Autowired Converter converter;
	@Autowired VerifierServices verifierService;
	
	@GetMapping("/verify/{passcode}")
	public ResponseEntity<String> verify(@PathVariable Integer passcode){
		return new ResponseEntity<String>(converter.convert(verifierService.checkPasscode(passcode)), HttpStatus.OK);
	}
}
