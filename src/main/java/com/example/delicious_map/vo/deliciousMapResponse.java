package com.example.delicious_map.vo;

import com.example.delicious_map.entity.DeliciousMapMain;
import com.example.delicious_map.entity.DeliciousMapSub;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliciousMapResponse {

	private String code;

	private String message;
	
	@JsonProperty("新增的餐廳資訊如下")
	private DeliciousMapMain deliciousMapMain;


	public DeliciousMapResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public DeliciousMapResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}



	public DeliciousMapResponse(String code, String message, DeliciousMapMain deliciousMapMain) {
		super();
		this.code = code;
		this.message = message;
		this.deliciousMapMain = deliciousMapMain;
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

	



}
