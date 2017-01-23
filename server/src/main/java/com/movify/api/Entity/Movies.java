package com.movify.api.Entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Movies.findAll",query="SELECT m FROM moviedetail m"),
	@NamedQuery(name="Movies.TopRatedMovie",query="SELECT m FROM movielist.moviedetail m where m.list_type = \"movie\" order by list_imdbRating limit 10" ),
	@NamedQuery(name="Movies.TopRatedSeries",query="SELECT m FROM movielist.moviedetail m where m.list_type = \"series\" order by list_imdbRating limit 10"),
	@NamedQuery(name="Movies.Moviename",query="SELECT m FROM moviedetail m where Lower(m.list_title) like \"%:pName%\""),
	@NamedQuery(name="Movies.Movielist",query="Select m from moviedetail m where lower(m.list_type) =\":pType\" and lower(m.list_genre) like \"%:pGenre%\""),
	
})
public class Movies {

	@Id
	@Column
	private String Id;
	private String Name;
	private String Year;

	@Id
	@Column
	private String Director;
	private String Rated;
	private String InvolvedActors;
	private String IMDBRating;
	private String MovieType;
	 

	public Movies(){
		
	}
	
	
	
	public String getId() {
		return Id;
	}


	public void setId(String id) {
		Id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getYear() {
		return Year;
	}


	public void setYear(String year) {
		Year = year;
	}


	public String getDirector() {
		return Director;
	}


	public void setDirector(String director) {
		Director = director;
	}


	public String getRated() {
		return Rated;
	}


	public void setRated(String rated) {
		Rated = rated;
	}


	public String getInvolvedActors() {
		return InvolvedActors;
	}


	public void setInvolvedActors(String involvedActors) {
		InvolvedActors = involvedActors;
	}


	public String getIMDBRating() {
		return IMDBRating;
	}


	public void setIMDBRating(String iMDBRating) {
		IMDBRating = iMDBRating;
	}


	public String getMovieType() {
		return MovieType;
	}


	public void setMovieType(String movieType) {
		MovieType = movieType;
	}

	
	
}
