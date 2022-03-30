package com.stocktraderz.dto;

import java.util.List;

import com.stocktraderz.models.Stock;

public class ProfileDTO {
	
	private String id;
	private String profileName;
	private List<Stock> stocks;
	
	
	public ProfileDTO(String id, String profileName, List<Stock> stocks) {
		this.id = id;
		this.profileName = profileName;
		this.stocks = stocks;
	}
	
	public ProfileDTO() {
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
	@Override
	public String toString() {
		return "ProfileDTO [id=" + id + ", profileName=" + profileName + ", stocks=" + stocks + "]";
	}
	
	
}
