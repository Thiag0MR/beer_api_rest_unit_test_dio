package com.digitalinnovation.beerapi.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.digitalinnovation.beerapi.enums.BeerType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeerDTO {
	
	private Long id;
	
	@NotNull
	@Size(min = 1, max = 200)
	private String name;
	
	@NotNull
	@Size(min = 1, max = 200)
	private String brand;
	
	@NotNull
	@Max(500)
	private int max;

	@NotNull
	@Max(100)
	private int quantity;
	
	@NotNull
	private BeerType type;
}
