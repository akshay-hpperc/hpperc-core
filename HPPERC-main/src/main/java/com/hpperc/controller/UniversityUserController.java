package com.hpperc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("universityUser")
public class UniversityUserController {
	
	@GetMapping("index")
	public String index() {
		return "universityUser/index";
	}
}
