package com.example.delicious_map.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddInfoRequest {
	
	@JsonProperty("Store-Name")
	private String storeName;
	
	@JsonProperty("Store-City")
	private String storeCity;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreCity() {
		return storeCity;
	}

	public void setStoreCity(String storeCity) {
		this.storeCity = storeCity;
	}
	
	

}
