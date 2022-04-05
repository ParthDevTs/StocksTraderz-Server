package com.stocktraderz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String shortName;
	@Column(name="stockName")
	private String name;
	private String market;
	private float highPrice;
	private float lowPrice;
	private float buyPrice;
	private String profileId;
	
	public Stock() {
		
	}

	public Stock(long id, String shortName, String name, String market, float highPrice, float lowPrice, float buyPrice,
			String profileId) {
		this.id = id;
		this.shortName = shortName;
		this.name = name;
		this.market = market;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.buyPrice = buyPrice;
		this.profileId = profileId;
	}

	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getShortName() {
		return shortName;
	}



	public void setShortName(String shortName) {
		this.shortName = shortName;
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



	public String getProfileId() {
		return profileId;
	}



	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}



	@Override
	public String toString() {
		return "Stock [id=" + id + ", shortName=" + shortName + ", name=" + name + ", market=" + market + ", highPrice="
				+ highPrice + ", lowPrice=" + lowPrice + ", buyPrice=" + buyPrice + ", profileId=" + profileId + "]";
	}




}
