package com.moviefy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.moviefy.entity.Movies;
import com.moviefy.exception.BadRequestException;
import com.moviefy.repository.MovieTableAcess;

public class MovieAccessImpl  implements MovieAccess{

	@Autowired
	private MovieTableAcess moviesrepo;
	
	
	@Override
	public Movies Create(Movies movie) {
		try{
		return moviesrepo.create(movie);
		}catch(Exception ex){
			
			throw new BadRequestException("Error Adding new entity ");
			
		}
		
		
	}

	@Override
	public List<Movies> findAll() {
	
		return moviesrepo.findall();
		
	}

	@Override
	public List<Movies> findbytype(String type) {

		return moviesrepo.findmoviebytype(type);
	}

	@Override
	public List<Movies> findbyname(String type, String name) {

		return moviesrepo.findmovie(type, name);
	}

}
