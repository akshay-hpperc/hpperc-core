package com.hpperc.enums;

import lombok.Getter;


@Getter
public enum UserRole {
	MASTER_ADMIN("MASTER_ADMIN"),
	HP_ADMIN("HP_ADMIN"), 
	HP_USER("HP_USER"),
	UNIVERSITY_ADMIN("UNIVERSITY_ADMIN"),
	UNIVERSITY_USER("UNIVERSITY_USER");	

	private String type;
	
	UserRole(String type){
		this.type = type;
	}

	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
}