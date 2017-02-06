package com.moviefy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries(
		@NamedQuery(name="Comments.Moviecomments",query= "select mi from  movieinteraction mi where idMovielist = :pMovieid")
		)
@Table(name ="movieinteraction",schema="movielist")
public class UserMovieInteract {

	
	@Column(name ="idMovieinteratcion")
	private int id;
	@Column(name ="idMovielist")
	private int movieid;
	@Column(name ="idUser")
	private int iduser;
	@Column(name ="Comments")
	private String comments;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
}
