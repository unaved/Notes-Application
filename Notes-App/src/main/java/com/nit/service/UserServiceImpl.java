package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.nit.entity.User;
import com.nit.repository.IUserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements IUserService {
	
	private IUserRepository userRepository;
	
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired(required=true)
	public UserServiceImpl(IUserRepository userRepository,BCryptPasswordEncoder passwordEncoder)
	{
		this.userRepository=userRepository;
		this.passwordEncoder=passwordEncoder;
	}
	
	@Override
	public User saveUser(User user) {
		System.out.println(user);
		user.setUserRole("ROLE_USER");
		user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
		User newUser = this.userRepository.save(user);
		return newUser;
	}

	@Override
	public boolean emailExistOrNot(String email) {
		return this.userRepository.existsByUserEmail(email);
		
	}

	@Override
	public User getUserByUserEmail(String email) {
		return this.userRepository.findByUserEmail(email);
	}
	
	//remove Sesstion Message
	public void removeSesstionMessage() {
		HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		session.removeAttribute("message");
	}
	

}
