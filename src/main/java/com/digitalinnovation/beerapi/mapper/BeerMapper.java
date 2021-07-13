package com.digitalinnovation.beerapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.digitalinnovation.beerapi.dto.BeerDTO;
import com.digitalinnovation.beerapi.entity.Beer;

@Mapper
public interface BeerMapper {
	
	BeerMapper INSTANCE = Mappers.getMapper(BeerMapper.class);
	
	Beer beerDtoToBeer (BeerDTO beerDTO);
	
	BeerDTO beerToBeerDTO (Beer beer);
}
