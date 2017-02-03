package com.moviefy.service;

import java.util.List;

import com.moviefy.entity.User;


public interface  LogonAccess {

	public List<User> findall();
	
	public User finduser(String email);
	
	public User adduser(User user);
	
	public User validatelogon( String username, String password);
	
	public boolean updateuser( String email, String username, String password);
	
	public boolean deleteuser(String email);
	
	public User retrieveaccount(String emailaddress);
	
}
