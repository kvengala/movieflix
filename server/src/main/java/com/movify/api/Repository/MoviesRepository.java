package com.movify.api.Repository;


import java.util.List;

import com.movify.api.Entity.Movies;


public interface MoviesRepository {

	public List<Movies> findAll();
	
	public List<Movies> TopRatedMovie();
	
	public List<Movies> TopRatedSeries();
	
	public List<Movies> MovieList( String movie);
	
	public List<Movies> MovieList( String mType, String genre);
	
	
	
}
