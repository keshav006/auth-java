package com.service;

import java.util.List;

import com.model.User;

public interface UserService {
	
	void signup(User user);
	
	boolean login(String un, String psw);
	
	List<User> getAllUsers();

}
