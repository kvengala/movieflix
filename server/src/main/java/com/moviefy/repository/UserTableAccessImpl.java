package com.moviefy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moviefy.entity.User;


@Repository
public class UserTableAccessImpl implements UserTableAccess {

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User find(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.GetAccount",User.class);
		query.setParameter("pEmail",email);
		
		List<User> obtainedaccount = query.getResultList();
		if(obtainedaccount != null && obtainedaccount.size() ==1)
			return obtainedaccount.get(0);
		
		return null;
		
	}

	@Override
	public User create(User user) {
		try{
		em.persist(user);
		return user;
		}catch(Exception ex){
			
			ex.printStackTrace();
			throw ex;
		}

	}

	@Override
	public boolean update(String email, String username, String password) {
		TypedQuery<User>query = em.createNamedQuery("User.Update",User.class);
		query.setParameter("pUsername", username);
		query.setParameter("pPassword", password);
		query.setParameter("pEmail", email);
		if( query.executeUpdate() == 1)
			return true;
		
		return false;
		
	}

	@Override
	public boolean delete(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.Delete",User.class);
		query.setParameter("pEmail", email);
		
		List<User> users = query.getResultList();
		
		return (users.get(0) == null); 
		
		
	}

	@Override
	public User validateuser(String username, String password) {
	TypedQuery<User> query = em.createNamedQuery("User.Validate",User.class);
	query.setParameter("pUsername", username);
	query.setParameter("pPassword", password);
	
	List<User> users = query.getResultList();
	if(users!= null && users.size() == 1)
		return users.get(0);
	else
		return null;
	}

	@Override
	public List<User> findall() {
		TypedQuery<User> query = em.createNamedQuery("User.findall",User.class);
		return query.getResultList();
		
	}
	

}
