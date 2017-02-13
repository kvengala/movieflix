package com.moviefy.repository;

import java.util.List;

import com.moviefy.entity.Movies;


public interface MovieTableAcess {

	
	public Movies create(Movies movies);
	
	public List<Movies> findall();
	
	public Movies findbyid(String id);
	 
	public List<Movies> findmovie(String type, String name);
	
	public List<Movies> findmoviebytype(String type);
	
}
