package com.nit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	private String userName;
	
	private String userEmail;
	
	private String userAddress;
	
	private String userPhone;
	
	private String userGender;
	
	private String userPassword;
	
	private String userRole;

}
