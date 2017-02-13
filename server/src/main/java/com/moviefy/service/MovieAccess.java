package com.moviefy.service;

import java.util.List;

import com.moviefy.entity.Movies;

public interface MovieAccess {

	public Movies Create(Movies movie);
	
	public List<Movies> findAll();
	
	public List<Movies> findbytype(String type);
	
	public List<Movies> findbyname(String type, String name);
	
	public Movies findbyid(String id);
	
	public Movies writecomments(int userid, String Movieid, String comments );
	
}
