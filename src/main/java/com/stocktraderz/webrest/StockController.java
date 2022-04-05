package com.stocktraderz.webrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stocktraderz.exceptions.StockTraderzException;
import com.stocktraderz.models.Stock;
import com.stocktraderz.service.StockService;

@RestController
public class StockController {

	@Autowired
	private StockService stockService;
	
	@GetMapping("/profile/{profileId}/stockList")
	public List<Stock> getAllStocksByProfile (@PathVariable String profileId){
		return stockService.getAllStocksByProfileId(profileId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/profile/{profileId}/stocks")
	public void addStockToProfile(@RequestBody Stock stock, @PathVariable String profileId) throws StockTraderzException {
		stockService.addStockToPofile(stock, profileId);

	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/stocks/{id}")
	public ResponseEntity<String> updateStock(@RequestBody Stock stock, @PathVariable String id) {
		String updateResult = stockService.updateStock(id, stock);
		if(updateResult.equals("Not Found")) {
			return new ResponseEntity<String>(stock.getId()+": Not Found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(updateResult, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/stocks/{id}")
	public ResponseEntity<String> deleteStock(@PathVariable String id) {
		stockService.deleteStock(id);
		
		
		return new ResponseEntity<String>("SuccessFully Deleted: "+ id, HttpStatus.OK);
	}
}
