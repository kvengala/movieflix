package com.moviefy.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import com.moviefy.entity.UserMovieInteract; 


@Entity
@NamedQueries({
	@NamedQuery(name = "Movies.findall", query = "select m from Movies m"),
	@NamedQuery(name = "Movies.findbytpe", query = "select m from Movies m where m.list_type = :pListtype  "),
	@NamedQuery(name = "Movies.findbyname", query = "select m from Movies m where m.list_type = :pListtype and m.list_title like \":ptiltle\"  ")
	
})
@Table(name ="moviedetail",schema="movielist")
public class Movies {
	@Column(name ="list_imdbID")
	private String id;
	@Column(name ="list_title")
	private String list_title;
	@Column(name ="list_year")
	private  String list_year;
	@Column(name ="list_rated")
	private  String list_rated;
	@Column(name ="list_released")
	private  String list_released;
	@Column(name ="list_runtimee")
	private String list_runtime;
	@Column(name ="list_genre")
	private  String list_genre;
	@Column(name ="list_director")
	private String list_director;
	@Column(name ="list_actors")
	private String list_actors;
	@Column(name ="list_plot")
	private String list_plot;
	@Column(name ="list_language")
	String list_language;
	@Column(name ="list_country")
	String list_country;
	@Column(name ="list_poster")
	String list_poster;
	@Column(name ="list_imdbRating")
	String list_imdbRating;
	@Column(name ="list_type")
	String list_type;
	
	private List<UserMovieInteract> usercommnets;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getList_year() {
		return list_year;
	}
	public void setList_year(String list_year) {
		this.list_year = list_year;
	}
	public String getList_rated() {
		return list_rated;
	}
	public void setList_rated(String list_rated) {
		this.list_rated = list_rated;
	}
	public String getList_released() {
		return list_released;
	}
	public void setList_released(String list_released) {
		this.list_released = list_released;
	}
	public String getList_runtime() {
		return list_runtime;
	}
	public void setList_runtime(String list_runtime) {
		this.list_runtime = list_runtime;
	}
	public String getList_genre() {
		return list_genre;
	}
	public void setList_genre(String list_genre) {
		this.list_genre = list_genre;
	}
	public String getList_director() {
		return list_director;
	}
	public void setList_director(String list_director) {
		this.list_director = list_director;
	}
	public String getList_actors() {
		return list_actors;
	}
	public void setList_actors(String list_actors) {
		this.list_actors = list_actors;
	}
	public String getList_plot() {
		return list_plot;
	}
	public void setList_plot(String list_plot) {
		this.list_plot = list_plot;
	}
	public String getList_language() {
		return list_language;
	}
	public void setList_language(String list_language) {
		this.list_language = list_language;
	}
	public String getList_country() {
		return list_country;
	}
	public void setList_country(String list_country) {
		this.list_country = list_country;
	}
	public String getList_poster() {
		return list_poster;
	}
	public void setList_poster(String list_poster) {
		this.list_poster = list_poster;
	}

	public String getList_title() {
		return list_title;
	}
	public void setList_title(String list_title) {
		this.list_title = list_title;
	}
	public String getList_imdbRating() {
		return list_imdbRating;
	}
	public void setList_imdbRating(String list_imdbRating) {
		this.list_imdbRating = list_imdbRating;
	}
	public String getList_type() {
		return list_type;
	}
	public void setList_type(String list_type) {
		this.list_type = list_type;
	}
	public List<UserMovieInteract> getUsercommnets() {
		return usercommnets;
	}
	public void setUsercommnets(List<UserMovieInteract> usercommnets) {
		this.usercommnets = usercommnets;
	}

	
	
	
		
}
