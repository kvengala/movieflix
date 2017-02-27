package com.moviefy.repository;
import java.util.List;

import com.moviefy.entity.*;
public interface UserTableAccess {

	public List<User> findall();
	
	public User find(String email);

	public User create(User user);
	
	public User validateuser( String username, String password);

	public boolean update(String email,String username, String password);

	public boolean delete(String email);
}
