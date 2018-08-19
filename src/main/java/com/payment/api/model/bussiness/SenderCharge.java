package com.payment.api.model.bussiness;

public class SenderCharge {

	private double amount;
	private String curreny;
	
	public SenderCharge(double amount, String curreny) {
		super();
		this.amount = amount;
		this.curreny = curreny;
	}
	
	public SenderCharge() {
		super();
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurreny() {
		return curreny;
	}
	public void setCurreny(String curreny) {
		this.curreny = curreny;
	}	
}
