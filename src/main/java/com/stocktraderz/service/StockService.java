package com.stocktraderz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktraderz.exceptions.StockTraderzException;
import com.stocktraderz.models.Profile;
import com.stocktraderz.models.Stock;
import com.stocktraderz.repository.ProfileRepository;
import com.stocktraderz.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private ProfileRepository profileRepository;

	public List<Stock> getAllStocks() {

		List<Stock> stocksList = new ArrayList<>();
		stockRepository.findAll().forEach(stocksList::add);
		return stocksList;
	}

	public Stock getStock(String id) throws StockTraderzException {
		Optional<Stock> stockoptional = stockRepository.findById(id);

		if (stockoptional.isEmpty()) {
			throw new StockTraderzException("No Such Stock Exists");
		} else {
			return stockoptional.get();
		}

	}

	public void addStock(Stock stock) {
		stockRepository.save(stock);
	}

	public String updateStock(String id, Stock stock) {

		Stock savedStock = stockRepository.save(stock);

		if (savedStock != null) {
			return id + ": Successfully updated";
		} else {
			return "Not Found";
		}

	}

	public void deleteStock(String id) {
		stockRepository.deleteById(id);

	}

	
	/*
	 * To add stocks to an existing Profile, Will return an error if 
	 * profile doesn't exists
	 * 
	 */

	public void addStockToPofile(Stock stock, String profileId) throws StockTraderzException {

		Optional<Profile> profileOptional = profileRepository.findById(profileId);
		if (profileOptional.isEmpty())
			throw new StockTraderzException("Profile Not Found");
		Profile profile = profileOptional.get();
		stock.setProfileId(profileId);
		stockRepository.save(stock);
		List<Stock> savedStockList = profile.getStocks();
		if (savedStockList == null) {
			List<Stock> stockList = new ArrayList<>();
			stockList.add(stock);
			profile.setStocks(stockList);
			profileRepository.save(profile);

		} else {
			//Check if stock already exists then add
			savedStockList.add(stock);
			profile.setStocks(savedStockList);
			profileRepository.save(profile);
		}

	}
	
	
	/*To get all stocks for a 
	 * particular profile
	 */

	public List<Stock> getAllStocksByProfileId(String profileId) {
		return stockRepository.findByProfileId(profileId);
	}

}
