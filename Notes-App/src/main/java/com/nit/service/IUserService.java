package com.nit.service;

import com.nit.entity.User;

public interface IUserService {
	
	User saveUser(User user);
	
	boolean emailExistOrNot(String email);
	
	User getUserByUserEmail(String email);
	 

}
