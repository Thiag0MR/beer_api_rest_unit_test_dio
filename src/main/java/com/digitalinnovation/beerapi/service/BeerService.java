package com.digitalinnovation.beerapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinnovation.beerapi.dto.BeerDTO;
import com.digitalinnovation.beerapi.entity.Beer;
import com.digitalinnovation.beerapi.exceptions.BeerAlreadyRegisteredException;
import com.digitalinnovation.beerapi.mapper.BeerMapper;
import com.digitalinnovation.beerapi.repository.BeerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerService {
	
	private final BeerRepository beerRepository;
	
	public BeerDTO createBeer(BeerDTO beerDTO) throws BeerAlreadyRegisteredException {
		verifyIfBeerIsAlreadyRegistered(beerDTO.getName());
		Beer beer = BeerMapper.INSTANCE.beerDtoToBeer(beerDTO);
		Beer savedBeer = beerRepository.save(beer);
		return BeerMapper.INSTANCE.beerToBeerDTO(savedBeer);
	}
	
	private void verifyIfBeerIsAlreadyRegistered(String beerName) throws BeerAlreadyRegisteredException {
		Optional<Beer> optFoundBeer = beerRepository.findByName(beerName);
		if (!optFoundBeer.isPresent()) {
			throw new BeerAlreadyRegisteredException(beerName);
		}
	}
}
