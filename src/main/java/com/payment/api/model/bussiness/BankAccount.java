package com.payment.api.model.bussiness;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="bank_account")
public class BankAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Field(value="id")
	private String id;
	
	@Field(value="account_number")
	@Indexed(unique=true)
	private String account_number;
	
	@Field(value="account_name")
	private String account_name;	
		
	@Field(value="account_number_code")
	private String account_number_code;
	
	@Field(value="account_type")
	private int account_type;
	
	@Field(value="address")
	private String address;
	
	@Field(value="name")
	private String name;
	
	@Field(value="bank")
	@DBRef
	private Bank bank;
		
	public BankAccount(String account_number, String account_name, String account_number_code,
			int account_type, String address, String name, Bank bank) {
		super();
		this.account_number = account_number;
		this.account_name = account_name;
		this.account_number_code = account_number_code;
		this.account_type = account_type;
		this.address = address;
		this.name = name;
		this.bank = bank;
	}

	public BankAccount() {
		super();
	}
	
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getAccount_number_code() {
		return account_number_code;
	}
	public void setAccount_number_code(String account_number_code) {
		this.account_number_code = account_number_code;
	}
	public int getAccount_type() {
		return account_type;
	}
	public void setAccount_type(int account_type) {
		this.account_type = account_type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	
	
}
