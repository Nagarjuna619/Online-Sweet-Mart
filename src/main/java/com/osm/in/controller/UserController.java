package com.osm.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osm.in.entity.User;
import com.osm.in.serviceimpl.UserServiceImpl;



@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserServiceImpl userService;
	
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user)
	{
		return userService.addUser(user);
	}
	
	@PutMapping("/updateuser")
	public User updateUser(@RequestBody User user)
	{
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/canceluser/{userId}")
	public User cancelUser(@PathVariable("userId") long userId)
	{
		return userService.cancelUser(userId);
	}
	
	@GetMapping("/showalluser")
	public List<User> showAllUsers()
	{
		return userService.showAllUsers();
	}
}
