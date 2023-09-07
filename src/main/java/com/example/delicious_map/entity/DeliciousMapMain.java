package com.example.delicious_map.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "delicious_map_main")
public class DeliciousMapMain {

	@Id
	@Column(name = "store_name")
	private String storeName;

	@Column(name = "store_city")
	private String storeCity;

	@Column(name = "store_review")
	private double storeReview;

	public DeliciousMapMain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeliciousMapMain(String storeName, String storeCity, double storeReview) {
		super();
		this.storeName = storeName;
		this.storeCity = storeCity;
		this.storeReview = storeReview;
	}

	public DeliciousMapMain(String storeName, String storeCity) {
		super();
		this.storeName = storeName;
		this.storeCity = storeCity;
	}

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

	public double getStoreReview() {
		return storeReview;
	}

	public void setStoreReview(double storeReview) {
		this.storeReview = storeReview;
	}

}
