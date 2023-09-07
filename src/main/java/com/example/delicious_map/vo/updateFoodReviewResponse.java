package com.example.delicious_map.vo;

import com.example.delicious_map.entity.DeliciousMapMain;
import com.example.delicious_map.entity.DeliciousMapSub;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateFoodReviewResponse {

	private String code;

	private String message;

	@JsonProperty("更新後的餐廳評價如下")
	private DeliciousMapMain deliciousMapMain;

	@JsonProperty("更新後的餐點評價如下")
	private DeliciousMapSub deliciousMapSub;

	public UpdateFoodReviewResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateFoodReviewResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public UpdateFoodReviewResponse(String code, String message, DeliciousMapMain deliciousMapMain,
			DeliciousMapSub deliciousMapSub) {
		super();
		this.code = code;
		this.message = message;
		this.deliciousMapMain = deliciousMapMain;
		this.deliciousMapSub = deliciousMapSub;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DeliciousMapMain getDeliciousMapMain() {
		return deliciousMapMain;
	}

	public void setDeliciousMapMain(DeliciousMapMain deliciousMapMain) {
		this.deliciousMapMain = deliciousMapMain;
	}

	public DeliciousMapSub getDeliciousMapSub() {
		return deliciousMapSub;
	}

	public void setDeliciousMapSub(DeliciousMapSub deliciousMapSub) {
		this.deliciousMapSub = deliciousMapSub;
	}

}
