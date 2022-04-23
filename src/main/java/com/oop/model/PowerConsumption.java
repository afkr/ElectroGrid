package com.oop.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.ws.rs.FormParam;


public class PowerConsumption {
	private int Id;
	private int UserId;
	private String MobileNumber;
	private int Units;
	private Date BillDate;
	
	public PowerConsumption(String mobileNumber, int units, int userId) {
		this.MobileNumber = mobileNumber;
		this.Units = units;
		this.UserId = userId;
		this.BillDate = new Date();
	}
	
	public PowerConsumption(int id, String mobileNumber, int units, int userId) {
		this.Id = id;
		this.MobileNumber = mobileNumber;
		this.Units = units;
		this.UserId = userId;
	}
	
	public PowerConsumption() {
		
	}
	
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
	public Date getBillDate() {
		return BillDate;
	}
	public void setBillDate(Date date) {
		BillDate = date;
	}
	
	
}
