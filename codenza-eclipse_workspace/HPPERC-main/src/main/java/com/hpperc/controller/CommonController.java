package com.hpperc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hpperc.model.Role;
import com.hpperc.service.ICommonService;

@Controller
@RequestMapping("common")
public class CommonController {
	
	@Autowired
	ICommonService commonService;
	
	@GetMapping("getAllRoles")
	public List<Role> getAllRoles() {
		
		return commonService.getAllRoles();
		 
	}
	
}
