package com.digitalinnovation.beerapi.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.digitalinnovation.beerapi.enums.BeerType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
	@Max(500)
	private int quantity;
	
	@NotNull
	private BeerType type;
}
