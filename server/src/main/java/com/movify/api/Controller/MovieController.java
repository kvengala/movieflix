package com.movify.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movify.api.Entity.Movies;
import com.movify.api.Service.MovieService;

@RestController
@RequestMapping(value="movies")

public class MovieController {

	@Autowired
	private MovieService mservice;
	
	@RequestMapping(method= RequestMethod.GET)
	public List<Movies> listAll(){
		
		return mservice.listAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public List<Movies> getMovies(@PathVariable("id") String namepattern){
		return mservice.getMovies(namepattern);
		
	}
	
	public List<Movies> getTopRatedMovies(){
		
	}
	
	public List<Movies> getTopRatedtvSeries(){
		
	}
	
	public List<Movies> getMoviesonYear(String Year){
		
		
	}
	
	public List<Movies> getMoviesonGenre(String genre){
		
	}
	
	public List<Movies> getMoviesonType(String Type){
		
		
	}
	
	
	
}
