package com.digitalinnovation.beerapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalinnovation.beerapi.entity.Beer;

public interface BeerRepository extends JpaRepository<Beer, Long>{

    Optional<Beer> findByName(String name);
}
