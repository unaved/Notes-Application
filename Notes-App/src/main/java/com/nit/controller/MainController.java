package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nit.entity.User;
import com.nit.service.IUserService;

import jakarta.servlet.http.HttpSession;

@Controller
//@RequestMapping("/main")
public class MainController {
	
	@Autowired
	IUserService userService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	
	@PostMapping("/save_user")
	public String saveUser(@ModelAttribute User user, HttpSession session) {
		//check user exist or not
		System.out.println(user);
		//existsBy Finder Method
		//boolean userExistOrNot = this.userService.emailExistOrNot(user.getEmail());
		
		//findBy Finder Method
		User userExistOrNot = this.userService.getUserByUserEmail(user.getUserEmail());
		
		if(userExistOrNot != null) {
			session.setAttribute("message", "User already exist!");
		}else {
			
			User saveUser = this.userService.saveUser(user);
			
			if(saveUser!=null) {
				session.setAttribute("message", "User register successfully!");
			}else {
				session.setAttribute("message", "Something wrong on server!");
			}
			
		}
		
		
		//this portion for existsByEmail method
		
//		if(userExistOrNot) {
//			session.setAttribute("message", "User already exist!");
//			
//		}else {
//			
//			User saveUser = this.userService.saveUser(user);
//			
//			if(saveUser!=null) {
//				session.setAttribute("message", "User register successfully!");
//			}else {
//				session.setAttribute("message", "Something wrong on server!");
//			}
//		}
		
		System.out.println(user);
		
		return "redirect:/register";
	}
	
	
	@GetMapping("/signin")
	public String login() { 
		return "login";
	}
	

}
