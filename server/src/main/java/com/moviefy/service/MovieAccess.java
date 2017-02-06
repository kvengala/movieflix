package com.moviefy.service;

import java.util.List;

import com.moviefy.entity.Movies;

public interface MovieAccess {

	public Movies Create(Movies movie);
	
	public List<Movies> findAll();
	
	public List<Movies> findbytype(String type);
	
	public List<Movies> findbyname(String type, String name);
	
	
}
