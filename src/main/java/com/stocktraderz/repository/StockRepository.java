package com.stocktraderz.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.stocktraderz.models.Stock;

public interface StockRepository extends CrudRepository<Stock, String> {
	
	public List<Stock> findByProfileId(String profileId);

}
