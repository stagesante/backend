package com.stagee.proj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stagee.proj.model.User;
import com.stagee.proj.service.UserService;



@RestController
@RequestMapping("/v1")
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@PreAuthorize("hasRole('ROLE_MEDECIN') or hasRole('ROLE_INFERMIER')")
	@GetMapping("/users")
	public List<User> getAllUsers(Authentication authentication) {
		
		return userService.findAllUsers();
		
	}
		
	@PostMapping("/user")
	public ResponseEntity<User> saveusers(@RequestBody User newUser,Authentication auth) {
		System.out.println(newUser.getPseudo()+"  "+auth.getName());
		return ResponseEntity.status(HttpStatus.CREATED).body((userService.saveUser(newUser)));
		
	}
	
	@PreAuthorize("@userSecurity.hasUserId(authentication,#userId)")
	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") int userId, Authentication authentication) {
		System.out.println("Inside getuserbyid method");
		return ResponseEntity.ok().body(userService.findUserById(userId).get());
		
	}
	
	
	
	
	
	@GetMapping("/users/search")
	@PostAuthorize("returnObject.body.userName==authenticated.user")
	public ResponseEntity<User> userDetails(Authentication authentication, @RequestParam("cname") String cName) throws Exception {
		System.out.println(authentication.getName().toString());
		User User=userService.findByUserName(cName);
		if(User==null) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
		return ResponseEntity.ok().body(User);
		
	}
	
	

}
