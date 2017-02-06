package com.moviefy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.moviefy.entity.Movies;
import com.moviefy.entity.UserMovieInteract;
import com.moviefy.exception.BadRequestException;


@Repository
public class MovieTableAccessImpl implements MovieTableAcess {

	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<Movies> findall() {
		
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findall", Movies.class);
		List<Movies> movies = query.getResultList();
		
		for(Movies movie : movies){
			UserMovieInteraction usermovieinteraction = new UserMovieInteractImpl();
			List<UserMovieInteract> commentslist = usermovieinteraction.Getcomments(movie.getId());
			movie.setUsercommnets(commentslist);
		}

		if(movies == null)
				throw new BadRequestException("Improper input Error");
		
		return movies;
		
	}

	@Override
	public List<Movies> findmovie(String type, String name) {

		TypedQuery<Movies> query = em.createNamedQuery("Movies.findbyname", Movies.class);
		
		query.setParameter("pListtype", type);
		query.setParameter("ptiltle", name);
		
		List<Movies> movies = query.getResultList();
		
		for(Movies movie : movies){
			UserMovieInteraction usermovieinteraction = new UserMovieInteractImpl();
			List<UserMovieInteract> commentslist = usermovieinteraction.Getcomments(movie.getId());
			movie.setUsercommnets(commentslist);
		}

		if(movies == null)	
				throw new BadRequestException("Improper input Error");
		
		return movies;
	}

	@Override
	public List<Movies> findmoviebytype(String type) {
			TypedQuery<Movies> query = em.createNamedQuery("Movies.findbytpe", Movies.class);
		
		query.setParameter("pListtype", type);
		
		
		List<Movies> movies = query.getResultList();
		
		for(Movies movie : movies){
			UserMovieInteraction usermovieinteraction = new UserMovieInteractImpl();
			List<UserMovieInteract> commentslist = usermovieinteraction.Getcomments(movie.getId());
			movie.setUsercommnets(commentslist);
		}

		if(movies == null)	
				throw new BadRequestException("Improper input Error");
		
		return movies;
		

	}

	@Override
	public Movies create(Movies movies) {
		try{
			em.persist(movies);
			return movies;
			}catch(Exception ex){
				
				
				throw new BadRequestException("Improper Request");
			}
	}
	

}
