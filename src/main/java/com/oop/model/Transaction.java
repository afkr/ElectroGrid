package com.oop.model;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

	private String id;
	private String userid;
	private double transactionAmount;
	private String cardtype;
	private int cardnumber;
	private Date expirydate;
	private String cardholdername;
	private int code;
	

	public Transaction() {
		super();
	}

	public Transaction(String id, String userid, double transactionAmount, String cardtype, int cardnumber,
			Date expirydate, String cardholdername, int code) {
		super();
		this.id = id;
		this.userid = userid;
		this.transactionAmount = transactionAmount;
		this.cardtype = cardtype;
		this.cardnumber = cardnumber;
		this.expirydate = expirydate;
		this.cardholdername = cardholdername;
		this.code = code;
	}
	
	public Transaction(String userid, double transactionAmount, String cardtype, int cardnumber, Date expirydate,
			String cardholdername, int code) {
		super();
		this.userid = userid;
		this.transactionAmount = transactionAmount;
		this.cardtype = cardtype;
		this.cardnumber = cardnumber;
		this.expirydate = expirydate;
		this.cardholdername = cardholdername;
		this.code = code;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(int cardnumber) {
		this.cardnumber = cardnumber;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}
	public String getCardholdername() {
		return cardholdername;
	}
	public void setCardholdername(String cardholdername) {
		this.cardholdername = cardholdername;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	

}
