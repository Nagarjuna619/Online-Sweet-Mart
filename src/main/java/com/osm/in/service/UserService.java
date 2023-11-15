package com.osm.in.service;

import java.util.List;

import com.osm.in.entity.User;

public interface UserService {
	
	public User addUser(User user);
	
	public User updateUser(User user);
	
	public User cancelUser(long userId);
	
	public List<User> showAllUsers();
}
