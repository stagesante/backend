package com.stagee.proj.service;


import org.springframework.stereotype.Service;

import com.stagee.proj.model.User;
import com.stagee.proj.repo.UserRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class UserService implements IUserService{

	@Autowired
	private UserRepository userRepo;
	
	
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}


	
	public User saveUser(User newUser) {
		
		User user=userRepo.save(newUser);
		return user;
		
	}

	
	
	



	@Override
	public Optional<User> findUserById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}



	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	

	







	public void autoLogin(String pseudo, String password) {
		
		UserDetails userDetails=userDetailsService.loadUserByUsername(pseudo);
		UsernamePasswordAuthenticationToken token= new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
		
	authenticationManager.authenticate(token);
		
		if(token.isAuthenticated()) {
		}
				
	}


	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;

	
	
	
}
