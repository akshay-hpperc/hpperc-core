package com.hpperc.model;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@ConfigurationProperties("app")
@Data
public class AppProperties {

	 private String createUserMailSubject;
	 private String createUserMailBody;
	public String getCreateUserMailBody() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getCreateUserMailSubject() {
		// TODO Auto-generated method stub
		return null;
	}
	 
}
