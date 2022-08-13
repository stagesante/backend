package com.stagee.proj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.stagee.proj.repo.UserRepository;



@Component("userSecurity")
public class UserSecurity {
	
	@Autowired
	UserRepository userRepo;
	
	public boolean hasUserId(Authentication authentication, Integer userId) {
		
		int userID=userRepo.findByPseudo(authentication.getName()).getId();
//		System.out.println(userId+"  "+userID);
            if(userID==userId)
            	return true;
            
            return false;
       
    }
}
