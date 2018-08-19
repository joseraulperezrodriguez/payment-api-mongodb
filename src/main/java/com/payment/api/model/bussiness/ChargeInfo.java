package com.payment.api.model.bussiness;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection=ChargeInfo.collection)
public class ChargeInfo implements Serializable, IPDocument {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String collection = "charge_info"; 
	
	public String collection() {
		return collection;
	}

	
	@Id
	@Field(value="id")
	private String id;
	
	@Field(value="bearer_code")
	private String bearer_code;
	
	@Field(value="receiver_charges_amount")
	private double receiver_charges_amount;
	
	@Field(value="receiver_charges_currency")
	private String receiver_charges_currency;
	
	@Field(value="sender_charges")
	private List<SenderCharge> sender_charges;
	
	public ChargeInfo(String bearer_code, double receiver_charges_amount,
			String receiver_charges_currency, List<SenderCharge> sender_charges) {
		super();
		this.bearer_code = bearer_code;
		this.receiver_charges_amount = receiver_charges_amount;
		this.receiver_charges_currency = receiver_charges_currency;
		this.sender_charges = sender_charges;
	}
	
	public ChargeInfo() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBearer_code() {
		return bearer_code;
	}

	public void setBearer_code(String bearer_code) {
		this.bearer_code = bearer_code;
	}

	public double getReceiver_charges_amount() {
		return receiver_charges_amount;
	}

	public void setReceiver_charges_amount(double receiver_charges_amount) {
		this.receiver_charges_amount = receiver_charges_amount;
	}

	public String getReceiver_charges_currency() {
		return receiver_charges_currency;
	}

	public void setReceiver_charges_currency(String receiver_charges_currency) {
		this.receiver_charges_currency = receiver_charges_currency;
	}

	public List<SenderCharge> getSender_charges() {
		return sender_charges;
	}

	public void setSender_charges(List<SenderCharge> sender_charges) {
		this.sender_charges = sender_charges;
	}
	
}
