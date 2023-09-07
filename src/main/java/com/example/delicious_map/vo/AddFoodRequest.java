package com.example.delicious_map.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddFoodRequest {
	
	@JsonProperty("Store-Name")
	private String storeName;
	
	@JsonProperty("Food-Name")
	private String foodName;
	
	@JsonProperty("Price")
	private int price;
	
	@JsonProperty("Food-Review")
	private int foodReview;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getFoodReview() {
		return foodReview;
	}

	public void setFoodReview(int foodReview) {
		this.foodReview = foodReview;
	}

	
	
}
