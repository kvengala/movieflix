package com.movify.api.Repository;

import java.util.List;

import com.movify.api.Entity.Movies;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class MoviesRepositoryImpl implements MoviesRepository{

	@PersistenceContext
	private EntityManager em;
	

	public List<Movies> findAll() {
		
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findAll", Movies.class);
		return query.getResultList();
		
	}

	public List<Movies> TopRatedMovie() {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.TopRatedMovie", Movies.class);
		return query.getResultList();
   
	}

	public List<Movies> TopRatedSeries() {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.TopRatedSeries", Movies.class);
		return query.getResultList();	
		
	}

	public List<Movies> MovieList(String movie) {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.Moviename", Movies.class);
		
		query.setParameter("pName", movie);
		
		return query.getResultList();
	}

	public List<Movies> MovieList( String mType, String genre) {
		
		TypedQuery<Movies> query = em.createNamedQuery("Movies.Movielist", Movies.class);
		query.setParameter("pType", mType);
		query.setParameter("pGenre", genre);
		return query.getResultList();
	}

}
