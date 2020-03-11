package edu.miu.carRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.carRental.domain.User;
import edu.miu.carRental.serviceImp.UserServiceImp;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImp userService;
	
	@PostMapping("/user")
    public User addUser(@RequestBody User user){
		System.out.println("USER ADDED::::::::::;");
        return userService.save(user);
    }

}
