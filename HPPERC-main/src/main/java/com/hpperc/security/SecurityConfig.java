package com.hpperc.security;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hpperc.enums.UserRole;
import com.hpperc.schedule.LogsSchedular;
import com.hpperc.service.UserServiceImpl;

 


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static Logger logger=LogManager.getLogger(SecurityConfig.class);	
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		
		.authorizeRequests()
		
		// Secure all requests
		.antMatchers("/login?logout").permitAll()
		.antMatchers("/login?error").permitAll()
		.antMatchers("/includes/*").permitAll()
		.antMatchers("/masterAdmin/*").hasRole("MASTER_ADMIN")
		.antMatchers("/hpAdmin/*").hasRole("HP_ADMIN")
		.antMatchers("/hpUser/*").hasRole("HP_USER")
		.antMatchers("/universityAdmin/*").hasRole("UNIVERSITY_ADMIN")
		.antMatchers("/universityUser/*").hasRole("UNIVERSITY_USER")
		.anyRequest().authenticated()
		
		.and()
		
		// Login page and redirect URLs
		.formLogin()
		.loginPage("/login")
		.permitAll()
		
		// After success login where we need to redirect the web page
		// Lambda function has bee used see @AuthenticationSuccessHandler
		.successHandler((request,response,authentication)->{
			
			Optional<? extends GrantedAuthority> grantedAuthorityOptional = (Optional<? extends GrantedAuthority>) authentication
					.getAuthorities().stream().findFirst();
			if (grantedAuthorityOptional.isPresent()) {
				GrantedAuthority grantedAuthority = grantedAuthorityOptional.get();
				String role = grantedAuthority.getAuthority();
				logger.info("Role:::" + role);
				if (role.equals("ROLE_"+UserRole.MASTER_ADMIN.getType())) {
					logger.info("Role:::" + role);
					logger.info("request.getContextPath():::" + request.getContextPath());
					response.sendRedirect(request.getContextPath()+"/masterAdmin/masterAdminDashboard");
				} else if (role.equals("ROLE_"+UserRole.HP_ADMIN.getType())) {
					response.sendRedirect(request.getContextPath()+"/hpAdmin/hpAdminDashboard");
				} else if (role.equals("ROLE_"+UserRole.HP_USER.getType())) {
					response.sendRedirect(request.getContextPath()+"/hpUser/index");
				}
				else if (role.equals("ROLE_"+UserRole.UNIVERSITY_ADMIN.getType())) {
					response.sendRedirect(request.getContextPath()+"/universityAdmin/universityAdminDashboard");
				}
				else if (role.equals("ROLE_"+UserRole.UNIVERSITY_USER.getType())) {
					response.sendRedirect(request.getContextPath()+"/universityUser/index");
				}
			}
		})
		
		.and()
		
		//Logout
		.logout()
		
		.and()
		
		// Access denied page
		.exceptionHandling()
		.accessDeniedPage("/403");
				
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/assets/**", "/lib/**", "/scss/**", "/images/**");
	}
}
