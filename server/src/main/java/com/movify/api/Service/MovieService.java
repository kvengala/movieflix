package com.movify.api.Service;

import java.util.List;

import com.movify.api.Entity.Movies;

public interface MovieService {

	public List<Movies> listAll();
	
	public List<Movies> getMovies(String namepattern);
	
	public List<Movies> getTopRatedMovies();
	
	public List<Movies> getTopRatedtvSeries();
	
	public List<Movies> getMoviesonYear(String Year );
	
	public List<Movies> getMoviesonGenre(String genre);
	
	public List<Movies> getMoviesonType(String Type);
	
	
	
	
}
