package com.payment.api.model.bussiness;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection=Fx.collection)
public class Fx implements Serializable, IPDocument {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String collection = "fx";
	
	public String collection() {
		return collection;
	}

	@Id
	@Field(value="id")
	private String id;
	
	@Field(value="contract_reference")
	private String contract_reference;
	
	@Field(value="exchange_rate")
	private double exchange_rate;
	
	@Field(value="original_amount")
	private double original_amount;
	
	@Field(value="original_currency")
	private String original_currency;		
	
	public Fx(String contract_reference, double exchange_rate, double original_amount, 
			String original_currency) {
		super();
		this.contract_reference = contract_reference;
		this.exchange_rate = exchange_rate;
		this.original_amount = original_amount;
		this.original_currency = original_currency;
	}
	
	public Fx() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContract_reference() {
		return contract_reference;
	}
	public void setContract_reference(String contract_reference) {
		this.contract_reference = contract_reference;
	}
	public double getExchange_rate() {
		return exchange_rate;
	}
	public void setExchange_rate(double exchange_rate) {
		this.exchange_rate = exchange_rate;
	}
	public double getOriginal_amount() {
		return original_amount;
	}
	public void setOriginal_amount(double original_amount) {
		this.original_amount = original_amount;
	}
	public String getOriginal_currency() {
		return original_currency;
	}
	public void setOriginal_currency(String original_currency) {
		this.original_currency = original_currency;
	}
	
}
