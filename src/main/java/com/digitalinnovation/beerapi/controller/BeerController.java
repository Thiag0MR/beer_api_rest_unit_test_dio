package com.digitalinnovation.beerapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digitalinnovation.beerapi.dto.BeerDTO;
import com.digitalinnovation.beerapi.entity.Beer;
import com.digitalinnovation.beerapi.service.BeerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/beers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerController {
	
	private final BeerService beerService;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public BeerDTO createBeer(@Valid @RequestBody BeerDTO beerDTO) {
		return beerService.createBeer(beerDTO);
	}

}
