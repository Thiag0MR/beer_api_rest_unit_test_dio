package com.digitalinnovation.beerapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BeerNotFoundException extends Exception{
	
	public BeerNotFoundException(String beerName) {
		super(String.format("Beer with name %s was not found", beerName));
	}
	
	public BeerNotFoundException(Long id) {
		super(String.format("Beer with id %d was not found", id));
	}
}
