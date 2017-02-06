package com.moviefy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.moviefy.entity.UserMovieInteract;
import com.moviefy.exception.BadRequestException;

@Repository
public class UserMovieInteractImpl implements UserMovieInteraction {

	@PersistenceContext
	private EntityManager em;
	

	@Override
	public UserMovieInteract create(UserMovieInteract usermovieinteract) {
		try{
			em.persist(usermovieinteract);
			return usermovieinteract;
		}catch(Exception ex){
			throw new BadRequestException("Improper Request  ");
		}
		
		
		
	}

	@Override
	public List<UserMovieInteract> Getcomments(String movieid) {
		TypedQuery<UserMovieInteract> query = em.createNamedQuery("Comments.Moviecomments",UserMovieInteract.class);
		query.setParameter("pMovieid", movieid);
		
		List<UserMovieInteract> usermovielist = query.getResultList();
		
		if(usermovielist == null)
			throw new BadRequestException("Improper Parameter ");
		
		return usermovielist;	
		
	}

	
	
}
