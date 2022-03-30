package com.stocktraderz.dto;

import com.stocktraderz.models.Profile;

public class StockDTO {
	private String id;
	private String name;
	private String market;
	private float highPrice;
	private float lowPrice;
	private float buyPrice;
	private Profile profile;
	
	
	public StockDTO() {
	}
	
	public StockDTO(String id, String name, String market, float highPrice, float lowPrice, float buyPrice,
			Profile profile) {
		this.id = id;
		this.name = name;
		this.market = market;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.buyPrice = buyPrice;
		this.profile = profile;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public float getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(float highPrice) {
		this.highPrice = highPrice;
	}
	public float getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(float lowPrice) {
		this.lowPrice = lowPrice;
	}
	public float getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(float buyPrice) {
		this.buyPrice = buyPrice;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "StockDTO [id=" + id + ", name=" + name + ", market=" + market + ", highPrice=" + highPrice
				+ ", lowPrice=" + lowPrice + ", buyPrice=" + buyPrice + ", profile=" + profile + "]";
	}
	
	
}
