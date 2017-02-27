package com.moviefy.entity;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@NamedQueries({
	@NamedQuery(name="User.findall", query="SELECT u FROM User u "),
	@NamedQuery(name ="User.Validate",query="SELECT U from User U where U.username=:pUsername and U.password = :pPassword"),
	@NamedQuery(name ="User.GetAccount",query="SELECT U from User U where U.emailaddress = :pEmail"),
	@NamedQuery(name="User.Delete",query="delete from  User U where U.emailaddress = :pEmail"),
	@NamedQuery(name="User.Update",query="update User U set U.username = :pUsername , U.password = :pPassword where U.emailaddress = :pEmail")
})
@Table(name ="usertable",schema="movielist")
public class User {

	
	private String username;
	
	private String password;
	
	@Column( name ="email")
	private String emailaddress;
	
	@Id
	@Column(name ="ID")
	private String id;


	public User(){
		this.setId(UUID.randomUUID().toString());
	}
	
	public User(String username, String password, String emailaddress){
		this.username = username;
		this.password = password;
		this.emailaddress = emailaddress;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	
	
	
	
}
