package com.digitalinnovation.beerapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.digitalinnovation.beerapi.enums.BeerType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Beer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 50, nullable = false)
	private String brand;
	
	@Column(nullable = false)
	private int max;

	@Column(nullable = false)
	private int quantity;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private BeerType type;
}










