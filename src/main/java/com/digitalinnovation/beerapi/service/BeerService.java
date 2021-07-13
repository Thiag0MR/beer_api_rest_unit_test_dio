package com.digitalinnovation.beerapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinnovation.beerapi.dto.BeerDTO;
import com.digitalinnovation.beerapi.entity.Beer;
import com.digitalinnovation.beerapi.exceptions.BeerAlreadyRegisteredException;
import com.digitalinnovation.beerapi.exceptions.BeerNotFoundException;
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
	
	public BeerDTO findBeerByName(String beerName) throws BeerNotFoundException {

		Beer savedBeer = beerRepository.findByName(beerName)
				.orElseThrow(() -> new BeerNotFoundException(beerName));
		
		return BeerMapper.INSTANCE.beerToBeerDTO(savedBeer);
	}
	
	public List<BeerDTO> listBeers() {
		return beerRepository.findAll()
				.stream()
				.map((Beer beer) -> BeerMapper.INSTANCE.beerToBeerDTO(beer))
				.collect(Collectors.toList());
	}
	
	public void deleteById(Long id) throws BeerNotFoundException {
		verifyIfExists(id);
		beerRepository.deleteById(id);
	}
	
	private Beer verifyIfExists(Long id) throws BeerNotFoundException {
		return beerRepository.findById(id).orElseThrow(() -> new BeerNotFoundException(id));
	}

	private void verifyIfBeerIsAlreadyRegistered(String beerName) throws BeerAlreadyRegisteredException {
		Optional<Beer> optFoundBeer = beerRepository.findByName(beerName);
		if (optFoundBeer.isPresent()) {
			throw new BeerAlreadyRegisteredException(beerName);
		}
	}

	

}
