package com.movify.api.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	
})
public class Movies {

	@Id
	private String MovieId;
	private String Moviename;
	
	public Movies(){
		this.
	}
	
	public String getMovieId() {
		return MovieId;
	}
	
	
	public void setMovieId(String movieId) {
		MovieId = movieId;
	}
	
	
	public String getMoviename() {
		return Moviename;
	}
	
	
	public void setMoviename(String moviename) {
		Moviename = moviename;
	}
	
	
	
	
	
}
