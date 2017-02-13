package com.moviefy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviefy.OAuth.AuthenticationKeyGenerator;
import com.moviefy.entity.Movies;
import com.moviefy.entity.User;
import com.moviefy.exception.BadRequestException;
import com.moviefy.service.LogonAccess;
import com.moviefy.service.MovieAccess;

@RestController
@RequestMapping(value = "Movies")
public class MovieController {

	@Autowired
	private MovieAccess service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Movies> findAll() {
		
		List<Movies> allMovies  = service.findAll();
		
		if(allMovies == null)
			throw new BadRequestException("Invalid request");
		
		return allMovies;
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET, value ="{id}")
	public Movies findbyId(@PathVariable("id") String  id) {
		Movies Movie  = service.findbyid(id);
		
		if(Movie == null)
			throw new BadRequestException("Invalid request");
		
		return Movie;		
	}
	
	

	@RequestMapping(method = RequestMethod.GET, value ="{id}")
	public Movies findbyType(@PathVariable("id") String  id) {
		Movies Movie  = service.findbyid(id);
		
		if(Movie == null)
			throw new BadRequestException("Invalid request");
		
		return Movie;		
	}
	
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json",value="/query")
	@ResponseBody
	public List<Movies>  findbyquery(@RequestParam  String type, @RequestParam String name) {
		List<Movies> allMovies  = service.findbyname(type, name);
		
		if(allMovies == null)
			throw new BadRequestException("Invalid request");
		
		return allMovies; 
		
	}
	
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json",value="/type")
	@ResponseBody
	public List<Movies>  findbytype(@RequestParam  String type) {
		List<Movies> allMovies  = service.findbytype(type);
		
		if(allMovies == null)
			throw new BadRequestException("Invalid request");
		
		return allMovies; 
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/comment")
	@ResponseBody
	@Transactional
	public Movies addcomment(@RequestParam String  userid, @RequestParam   String Movieid, @RequestParam String comments )
	{
	try{
		return service.writecomments(Integer.parseInt(userid), Movieid, comments);
	}catch(Exception ex)
	{
		throw new BadRequestException("Improper Data Provided");
		
	}
	
	}
	
	
	
}
