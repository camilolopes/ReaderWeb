package com.camilolopes.readerweb.enums;

public enum StatusUser {
	ATIVE("ative"), INACTIVE("inactive");

	private String status;

	StatusUser(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		
		return status;
	}

	public String getStatus() {
		return status;
	}
}
