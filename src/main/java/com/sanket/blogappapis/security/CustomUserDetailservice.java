package com.sanket.blogappapis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sanket.blogappapis.entity.User;
import com.sanket.blogappapis.exceptions.ResourceNotFoundException;
import com.sanket.blogappapis.repositories.UserRepo;

@Service
public class CustomUserDetailservice implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loading user from database
		User userOptional = userRepo.findByEmail(username)
				.orElseThrow(() -> new ResourceNotFoundException("User ", "Eamil" + username, 0L));
		return userOptional;
	}

}