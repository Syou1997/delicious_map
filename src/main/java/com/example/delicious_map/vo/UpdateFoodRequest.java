package com.example.delicious_map.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateFoodRequest {
	
	@JsonProperty("Old-Name")
	private String OldName;
	
	@JsonProperty("New-Name")
	private String NewName;

	public String getOldName() {
		return OldName;
	}

	public void setOldName(String oldName) {
		OldName = oldName;
	}

	public String getNewName() {
		return NewName;
	}

	public void setNewName(String newName) {
		NewName = newName;
	}
	
}
