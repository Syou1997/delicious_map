package com.example.delicious_map.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "delicious_map_sub")
@Entity
public class DeliciousMapSub {

	@Column(name = "store_name")
	private String storeName;

	@Id
	@Column(name = "food_name")
	private String foodName;

	@Column(name = "price")
	private int price;

	@Column(name = "food_review")
	private int foodReview;

	public DeliciousMapSub() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeliciousMapSub(String foodName) {
		super();
		this.foodName = foodName;
	}

	public DeliciousMapSub(String storeName, String foodName, int price) {
		super();
		this.storeName = storeName;
		this.foodName = foodName;
		this.price = price;
	}

	public DeliciousMapSub(String storeName, String foodName, int price, int foodReview) {
		super();
		this.storeName = storeName;
		this.foodName = foodName;
		this.price = price;
		this.foodReview = foodReview;
	}

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
