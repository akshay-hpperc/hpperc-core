package com.hpperc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("universityAdmin")
public class UniversityAdminController {

	@GetMapping("universityAdminDashboard")
	public String index() {
		return "universityAdmin/universityAdminDashboard";
	}
	
}
