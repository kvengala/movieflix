package com.moviefy.OAuth;

import java.security.MessageDigest;

import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Component;

import com.moviefy.exception.InvalidInputException;

@Component
@Scope("session")
public  class AuthenticationKeyGenerator {

	
	static String publickeytoken;

	public static String  generateLogonkey(String credentials){
		try{
		credentials += System.currentTimeMillis();
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.update(credentials.getBytes());
		 StringBuffer autheticationkey = new StringBuffer();
		    for (int i = 0; i < messageDigest.digest().length; i++) 
		    	autheticationkey.append(Integer.toString((messageDigest.digest()[i] & 0xff) + 0x100, 16)
		                .substring(1));
		
		    publickeytoken = autheticationkey.toString();
	
		    return publickeytoken;
		
		}catch(Exception e){
			throw new InvalidInputException("Invalid Input Parameters");
		}
		
	}
	
	
	
	
}
