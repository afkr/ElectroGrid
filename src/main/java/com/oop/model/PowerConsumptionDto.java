package com.oop.model;

import java.util.Date;

public class PowerConsumptionDto {
	private int Id;
	private String Username;
	private int UserId;
	private String MobileNumber;
	private int Units;
	private Date BillDate;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public int getUnits() {
		return Units;
	}
	public void setUnits(int units) {
		Units = units;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public Date getBillDate() {
		return BillDate;
	}
	public void setBillDate(Date billDate) {
		BillDate = billDate;
	}
	
	
}
