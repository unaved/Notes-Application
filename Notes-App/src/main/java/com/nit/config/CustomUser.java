package com.nit.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.nit.entity.User;

public class CustomUser implements UserDetails{
	
	//class property
		private User user;
		
		//constructor of this class.
		//user come here...from of CustomUserDetailsService by this method  loadUserByUsername()
		public CustomUser(User user) 
		{
			super();
			this.user = user;
		}
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getUserRole());//takes role...
			
			return Arrays.asList(authority);
		}

		

		@Override
		public String getPassword() {
			
			return user.getUserPassword();
		}

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return user.getUserEmail();
		}

		@Override
		public boolean isAccountNonExpired() {
			
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			
			return true;
		}

		@Override
		public boolean isEnabled() {
			
			return true;
		}
	
}
