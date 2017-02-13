package com.moviefy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviefy.entity.Movies;
import com.moviefy.entity.UserMovieInteract;
import com.moviefy.exception.BadRequestException;
import com.moviefy.repository.MovieTableAcess;
import com.moviefy.repository.UserMovieInteraction;

@Service
public class MovieAccessImpl  implements MovieAccess{

	@Autowired
	private MovieTableAcess moviesrepo;
	
	@Autowired 
	private UserMovieInteraction userinteractrepo;
	
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
	
		 List<Movies> allmovies = moviesrepo.findall();
		 
		 for(Movies movie : allmovies){
			 
			movie.setUsercommnets( userinteractrepo.Getcomments(movie.getId()));
		 }
		 
		 return allmovies;
		 
		
	}

	@Override
	public List<Movies> findbytype(String type) {

		List<Movies> allmovies = moviesrepo.findmoviebytype(type);
		 
		 for(Movies movie : allmovies){
			 
			movie.setUsercommnets( userinteractrepo.Getcomments(movie.getId()));
		 }
		 
		 return allmovies;
	}

	@Override
	public List<Movies> findbyname(String type, String name) {

		List<Movies> allmovies = moviesrepo.findmovie(type, name);
		 
		 for(Movies movie : allmovies){
			 
			movie.setUsercommnets( userinteractrepo.Getcomments(movie.getId()));
		 }
		 
		 return allmovies;
	}

	@Override
	public Movies findbyid(String id) {
		Movies movie = moviesrepo.findbyid(id);
			movie.setUsercommnets( userinteractrepo.Getcomments(movie.getId()));
		 
		 
		 return movie;
	}

	@Override
	public Movies writecomments(int userid, String Movieid, String comments) {
		
		UserMovieInteract usermovieinteract = new UserMovieInteract();
		usermovieinteract.setComments(comments);
		usermovieinteract.setIduser(userid);
		usermovieinteract.setMovieid(Movieid);
		
		userinteractrepo.create(usermovieinteract);
		
		return findbyid(Movieid);
		
		
	}

}
