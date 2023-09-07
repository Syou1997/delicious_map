package com.example.delicious_map.vo;


import com.example.delicious_map.entity.DeliciousMapSub;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliciousSubResponse {
	
	private String code;

	private String message;
	
	@JsonProperty("新增的餐點資訊如下")
	private DeliciousMapSub deliciousMapSub;

	public DeliciousSubResponse() {
		super();
	}
	
	

	public DeliciousSubResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}


	
	
	public DeliciousSubResponse(String code, String message, DeliciousMapSub deliciousMapSub) {
		super();
		this.code = code;
		this.message = message;
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

	public DeliciousMapSub getDeliciousMapSub() {
		return deliciousMapSub;
	}

	public void setDeliciousMapSub(DeliciousMapSub deliciousMapSub) {
		this.deliciousMapSub = deliciousMapSub;
	}
	
	
}
