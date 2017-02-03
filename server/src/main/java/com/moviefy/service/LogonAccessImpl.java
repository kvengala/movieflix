package com.moviefy.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moviefy.entity.User;
import com.moviefy.exception.BadRequestException;
import com.moviefy.repository.UsertableAccess;

@Service
public class LogonAccessImpl implements LogonAccess{

	@Autowired
	private UsertableAccess userrepo;

	
	
	
	@Override
	public User adduser(User user) {
	
		return userrepo.create(user);
	}

	@Override
	@Transactional
	public User validatelogon(String username, String password) {
		User validuser = userrepo.validateuser(username, password);
		
		if(validuser == null)
			throw new BadRequestException("Improper Authentication Request");
		
		return validuser;
	}

	
	
	@Override
	public boolean updateuser(String email, String username, String password) {
			
		return userrepo.update(email,username, password);
			
			
		
	}

	@Override
	public boolean deleteuser(String email) {
	
		return userrepo.delete(email);
		
		
	}

	@Override
	public User retrieveaccount(String emailaddress) {
	
		return userrepo.find(emailaddress);
	}

	@Override
	@Transactional
	public List<User> findall() {
		
		return userrepo.findall();
	}

	@Override
	public User finduser(String email) {
		
		return userrepo.find(email);
	}

	
	

}
