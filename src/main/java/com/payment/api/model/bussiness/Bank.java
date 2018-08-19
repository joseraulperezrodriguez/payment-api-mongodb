package com.payment.api.model.bussiness;


import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="bank")
public class Bank implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Field(value="id")
	private String id;
	
	@Field(value="bank_id_code")
	private String bank_id_code;

	public Bank(String bank_id_code) {
		super();
		this.bank_id_code = bank_id_code;
	}
	
	public Bank() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBank_id_code() {
		return bank_id_code;
	}

	public void setBank_id_code(String bank_id_code) {
		this.bank_id_code = bank_id_code;
	}
	
	
	
	
}
