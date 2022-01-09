package com.hpperc.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.mail.MessagingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hpperc.enums.UserRole;
import com.hpperc.model.AppProperties;
import com.hpperc.model.Role;
import com.hpperc.model.User;
import com.hpperc.service.ICommonService;
import com.hpperc.service.ICommunicationService;
import com.hpperc.service.IRoleService;
import com.hpperc.service.IUserService;

@Controller
@RequestMapping("masterAdmin")
public class MasterAdminController {

	private static Logger logger=LogManager.getLogger(MasterAdminController.class);	
	
	@Autowired
	IUserService userService;
	
	@Autowired
	ICommonService commonSevice;
	
	@Autowired
	IRoleService roleService;
	
	@Autowired
	ICommunicationService communicationService;
	
	@Autowired
	AppProperties appProperties;
	
	@GetMapping("masterAdminDashboard")
	public String index() {
		return "masterAdmin/masterAdminDashboard";
	}
	
	@RequestMapping("hpAdminList")
	public ModelAndView hpAdminList() {
		
		Role role= roleService.findByRoleName("ROLE_HP_ADMIN");
		Set<User> userList = role.getUserList();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("userList", userList);
	 	
	 	return new ModelAndView("masterAdmin/hpAdminList", model); 
	}
	
	
	 @RequestMapping("/hpAdminForm")
	    public ModelAndView addNewUser() {
		  Map<String, Object> model = new HashMap<String, Object>();
		  model.put("user", new User());
		  model.put("role", new Role());
		  model.put("roleList", commonSevice.getAllRoles());
		  return new ModelAndView("masterAdmin/hpAdminForm", model);
	    }
	
	 @RequestMapping("/saveHpAdmin")
	    //public ModelAndView saveHpAdmin(@ModelAttribute("user") User user,@ModelAttribute("roleId") String roleId) {
	 public ModelAndView saveHpAdmin(@ModelAttribute("user")User user, BindingResult resultUser, @ModelAttribute("role")Role role, BindingResult resultRole) {
		 
		
		 String randomPassword=userService.randomPasswordGeneration();
		 
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		 String encodedPassword = passwordEncoder.encode(randomPassword);
			
		 logger.info("encodedPassword :: "+encodedPassword);
		 user.setPassword(encodedPassword);
		 
		 Set<Role> hpAdminRole = new HashSet<>();
		 hpAdminRole.add(roleService.findByRoleName("ROLE_"+UserRole.HP_ADMIN.getType()));
		 
		 user.setRoles(hpAdminRole);
		 user.setEnabled(true);
	 	 userService.saveUser(user);
	 	 
	 	 try {
	 		String createUserEmailMessage=appProperties.getCreateUserMailBody().replaceAll("\\{username\\}", user.getUsername())
	 											 .replaceAll("\\{password\\}", randomPassword);
	 		String createUserEmailSubject=appProperties.getCreateUserMailSubject();
	 		
			communicationService.sendEmailWithMessageToUser(user, createUserEmailSubject, createUserEmailMessage);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	
		 logger.info("First Name :: "+user.getFirstName());
		 logger.info("role_______ :: "+role.getName());
		  return new ModelAndView("redirect:/masterAdmin/hpAdminList");

	    }
	 
	 
	 /*
 	 @ModelAttribute
	 public List<MstRole> getRolesList() {
 	      return commonSevice.getAllRoles();
	   }
	    
	@RequestMapping(value = "/hpAdminForm", method = RequestMethod.GET)  
	public String hpAdminForm() {
		return "masterAdmin/hpAdminForm";
	}
	 
	 @RequestMapping("/hpAdminForm")
	    public ModelAndView addNewUser() {
	        ModelAndView modelAndView = new ModelAndView();
	        System.out.println("Roles :: " + commonSevice.getAllRoles().toString());
	        modelAndView.addObject("roles",  commonSevice.getAllRoles());
	        modelAndView.setViewName("masterAdmin/hpAdminForm");
	        return modelAndView;
	    }
	     
	  
	@RequestMapping(value = "/hpAdminForm", method = RequestMethod.GET)
	 public ModelAndView addPublication(@ModelAttribute("command")  User user,
	   BindingResult result) {
	  Map<String, Object> model = new HashMap()<String, Object>();
	  model.put("roles",  commonSevice.getAllRoles());
	  return new ModelAndView("addPublication", model);
	 }
	 
	 */
}
