package edu.miu.carRental.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import edu.miu.carRental.domain.User;
import edu.miu.carRental.service.UserService;

@RestController
@CrossOrigin(allowedHeaders = "*")
//@RequestMapping(value = "/admin/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

public class UserController {

    
    private UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
		// TODO Auto-generated constructor stub
    	this.userService=userService;
	}
    
    @GetMapping(value = "/list")
    public List<User> list() {
        return userService.findAll();
    }
    
    @PostMapping(value = "/add")
    public User addNewUser(@Valid @RequestBody User user) {
        return userService.save(user);
    }
    
    @GetMapping(value = "/get/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.findById(userId);
    }
    
    @PutMapping(value = "/update/{userId}")
    public User updateUser(@Valid @RequestBody User editedUser, @PathVariable Long userId) {
        return userService.update(editedUser, userId);
    }
    
    @DeleteMapping(value = "/delete/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.delete(userId);
    }
}