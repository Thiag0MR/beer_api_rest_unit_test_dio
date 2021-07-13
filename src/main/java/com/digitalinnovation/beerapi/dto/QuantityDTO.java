package com.digitalinnovation.beerapi.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuantityDTO {
	
	@Max(100)
	@NotNull
	private int quantity;
}
