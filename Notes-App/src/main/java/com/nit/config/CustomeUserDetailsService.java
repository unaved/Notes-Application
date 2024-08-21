package com.nit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nit.entity.User;
import com.nit.repository.IUserRepository;
@Service
public class CustomeUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = this.userRepository.findByUserEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found!");
		}else {
			return new CustomUser(user);//custom user class constructor.
		}
		
		
	}

}
