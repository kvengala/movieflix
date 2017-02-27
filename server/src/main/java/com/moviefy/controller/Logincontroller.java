package com.moviefy.controller;

import java.io.IOException;
import java.util.List;

import javax.json.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviefy.entity.*;
import com.moviefy.exception.BadRequestException;
import com.moviefy.service.LogonAccess;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviefy.OAuth.*;

import org.codehaus.jackson.JsonGenerationException;

@RestController
@RequestMapping(value = "User")
public class Logincontroller {

	@Autowired
	private LogonAccess service;


	
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String  validate(@RequestParam  String username, @RequestParam String password) {
		System.out.println(username +" " + password);
		
		User validuser =  service.validatelogon(username, password);
		
		String authorizationtoken = AuthenticationKeyGenerator.generateLogonkey( username + password);
		
		if(validuser != null)
			return ( "{ \" id \" : \""+ validuser.getId() +"\"username\" : \"" + validuser.getUsername()  + "\" , \"EmailAddress\": \"" + validuser.getEmailaddress() + "\",\"AuthO-Token\":\"" + authorizationtoken + "\" }");
		
		return ""; 
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public User  update(@RequestParam  String email, @RequestParam String username, @RequestParam String password) {
		
		if(!service.updateuser(email, username, password))
				return null;
		
		return service.finduser(email);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Signup")
	@ResponseBody
	@Transactional
	public User create(@RequestParam  String email, @RequestParam String username, @RequestParam String password ){
		if(service.finduser(email) == null)	{
			User user = new User(username, password, email); 
			return service.adduser(user);
			}
		return null;
			}
	
}
