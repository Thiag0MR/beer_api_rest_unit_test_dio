package com.digitalinnovation.beerapi.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuantityDTO {
	
	@Max(100)
	@NotNull
	private int quantity;
}
