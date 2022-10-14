package com.premsh.visitorsure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.premsh.visitorsure.config.DriverManagerConfig;

@RestController
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	public DriverManagerConfig conf;
	
	@GetMapping("/")
	public String index() {
		return "Welcome to visitorsure";
	}
	
	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}
}
