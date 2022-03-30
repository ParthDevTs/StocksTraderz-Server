package com.stocktraderz.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Profile {
	@Id
	private String id;
	private String profileName;
	@OneToMany
	private List<Stock> stocks;
	
	
	public Profile() {
	}
	public Profile(String id, String profileName, List<Stock> stocks) {
		this.id = id;
		this.profileName = profileName;
		this.stocks = stocks;
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
		return "Profile [id=" + id + ", profileName=" + profileName + ", stocks=" + stocks + "]";
	}
	
	

}
