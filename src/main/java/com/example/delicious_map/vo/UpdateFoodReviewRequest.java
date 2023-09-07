package com.example.delicious_map.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateFoodReviewRequest {

	@JsonProperty("Food_Name")
	private String foodName;
	
	@JsonProperty("New_Review")
	private int newReview;

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getNewReview() {
		return newReview;
	}

	public void setNewReview(int newReview) {
		this.newReview = newReview;
	}
	
	
}
