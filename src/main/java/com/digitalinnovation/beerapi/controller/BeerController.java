package com.digitalinnovation.beerapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digitalinnovation.beerapi.dto.BeerDTO;
import com.digitalinnovation.beerapi.dto.QuantityDTO;
import com.digitalinnovation.beerapi.exceptions.BeerAlreadyRegisteredException;
import com.digitalinnovation.beerapi.exceptions.BeerNotFoundException;
import com.digitalinnovation.beerapi.exceptions.BeerStockExceededException;
import com.digitalinnovation.beerapi.service.BeerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/beers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerController {
	
	private final BeerService beerService;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public BeerDTO createBeer(@Valid @RequestBody BeerDTO beerDTO) throws BeerAlreadyRegisteredException {
		return beerService.createBeer(beerDTO);
	}
	
	@GetMapping("/{name}")
	public BeerDTO findBeerByName(@PathVariable("name") String beerName) throws BeerNotFoundException {
		return beerService.findBeerByName(beerName);
	}
	
	@GetMapping
	public List<BeerDTO> listBeers() {
		return beerService.listBeers();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById (@PathVariable Long id) throws BeerNotFoundException {
		beerService.deleteById(id);
	}
	
	@PatchMapping("/{id}/increment")
	public BeerDTO increment(@PathVariable Long id, @RequestBody @Valid QuantityDTO quantity) throws BeerNotFoundException, BeerStockExceededException {
		return beerService.increment(id, quantity.getQuantity());
	}

}
