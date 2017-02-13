package com.moviefy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries(
		@NamedQuery(name="Comments.Moviecomments",query= "select mi from  UserMovieInteract mi where mi.movieid = :pMovieid")
		)
@Table(name ="movieinteraction",schema="movielist")
public class UserMovieInteract {

	@Id
	@Column(name ="idMovieinteraction")
	private int id;
	@Column(name ="idMovielist")
	private String  movieid;
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
	public String getMovieid() {
		return movieid;
	}
	public void setMovieid(String movieid) {
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
