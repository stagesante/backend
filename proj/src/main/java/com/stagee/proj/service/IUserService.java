package com.stagee.proj.service;

import java.util.List;
import java.util.Optional;

import com.stagee.proj.model.User;



public interface IUserService {

	
	public List<User> findAllUsers() ;

	public Optional<User> findUserById(int id);
	
	public User findByUserName(String userName) ;

}
