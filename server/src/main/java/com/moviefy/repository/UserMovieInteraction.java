package com.moviefy.repository;

import java.util.List;

import com.moviefy.entity.UserMovieInteract;

public interface UserMovieInteraction {

	public UserMovieInteract create(UserMovieInteract usermovieinteract);
	public List<UserMovieInteract> Getcomments(String movieid);
	
	
}
