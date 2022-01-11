package com.codenza.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class WebController {
	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Codenza Tech";
	}
	
	@RequestMapping("/hello")
	public String myData() {
		return "Hello Spring Boot Demo";
	}
}
