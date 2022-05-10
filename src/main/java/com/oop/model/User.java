package com.oop.model;

public class User {
	private int UserId;
	private String Name;
	private String Address;
	private String MobileNumber;
	
	public User(String name, String address, String mobileNumber) {
		Name = name;
		Address = address;
		MobileNumber = mobileNumber;
	}
	
	
	public User(int userId, String name, String address, String mobileNumber) {
		UserId = userId;
		Name = name;
		Address = address;
		MobileNumber = mobileNumber;
	}
	
	public User () {
		
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}

}
