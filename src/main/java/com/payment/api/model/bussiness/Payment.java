package com.payment.api.model.bussiness;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection=Payment.collection)
public class Payment implements Serializable, IPDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String collection = "payment";
	
	public String collection() {
		return collection;
	}

	
	@Id
	private String id;
	
	@Field(value="organization_id")
	private String organization_id;
	
	@Field(value="amount")
	private Double amount;

	@DBRef
	private ChargeInfo charge_info;
	
	@Field(value="currency")
	private String currency;
	
	@Field(value="end_to_end_reference")
	private String end_to_end_reference;
	
	@DBRef
	private Fx fx;
	
	@Field(value="numeric_reference")
	private Long numeric_reference;
	
	@Field(value="payment_purpose")
	private String payment_purpose;
	
	@Field(value="payment_scheme")
	private String payment_scheme;
	
	@Field(value="payment_type")
	private Integer payment_type;
	
	@Field(value="processing_date")
	@DateTimeFormat(iso=ISO.DATE)
	private Instant processing_date;
	
	@Field(value="reference")
	private String reference;
	
	@Field(value="scheme_payment_sub_type")
	private String scheme_payment_sub_type;
	
	@Field(value="scheme_payment_type")
	private String scheme_payment_type;
		
	@DBRef
	@Field(value="sponsor_party")
	private BankAccount sponsor_party;
	
	@DBRef
	@Field(value="sponsor_bank")
	private Bank sponsor_bank;

	@DBRef
	@Field(value="beneficiary")
	private BankAccount beneficiary;	
	
	@DBRef
	@Field(value="debtor")
	private BankAccount debtor;
			
	public Payment(String organization_id, double amount, ChargeInfo charge_info,
			String currency, String end_to_end_reference, Fx fx, long numeric_reference, String payment_purpose,
			String payment_scheme, int payment_type, Instant processing_date, String reference,
			String scheme_payment_sub_type, String scheme_payment_type, BankAccount sponsor_party,
			Bank sponsor_bank, BankAccount beneficiary, BankAccount debtor) {
		super();
		this.organization_id = organization_id;
		this.amount = amount;
		this.charge_info = charge_info;
		this.currency = currency;
		this.end_to_end_reference = end_to_end_reference;
		this.fx = fx;
		this.numeric_reference = numeric_reference;
		this.payment_purpose = payment_purpose;
		this.payment_scheme = payment_scheme;
		this.payment_type = payment_type;
		this.processing_date = processing_date;
		this.reference = reference;
		this.scheme_payment_sub_type = scheme_payment_sub_type;
		this.scheme_payment_type = scheme_payment_type;
		this.sponsor_party = sponsor_party;
		this.sponsor_bank = sponsor_bank;
		this.beneficiary = beneficiary;
		this.debtor = debtor;
	}
	
	public Payment() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrganization_id() {
		return organization_id;
	}

	public void setOrganization_id(String organization_id) {
		this.organization_id = organization_id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public ChargeInfo getCharge_info() {
		return charge_info;
	}

	public void setCharge_info(ChargeInfo charge_info) {
		this.charge_info = charge_info;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getEnd_to_end_reference() {
		return end_to_end_reference;
	}

	public void setEnd_to_end_reference(String end_to_end_reference) {
		this.end_to_end_reference = end_to_end_reference;
	}

	public Fx getFx() {
		return fx;
	}

	public void setFx(Fx fx) {
		this.fx = fx;
	}

	public Long getNumeric_reference() {
		return numeric_reference;
	}

	public void setNumeric_reference(Long numeric_reference) {
		this.numeric_reference = numeric_reference;
	}

	public String getPayment_purpose() {
		return payment_purpose;
	}

	public void setPayment_purpose(String payment_purpose) {
		this.payment_purpose = payment_purpose;
	}

	public String getPayment_scheme() {
		return payment_scheme;
	}

	public void setPayment_scheme(String payment_scheme) {
		this.payment_scheme = payment_scheme;
	}

	public Integer getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(Integer payment_type) {
		this.payment_type = payment_type;
	}

	public Instant getProcessing_date() {
		return processing_date;
	}

	public void setProcessing_date(Instant processing_date) {
		this.processing_date = processing_date;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getScheme_payment_sub_type() {
		return scheme_payment_sub_type;
	}

	public void setScheme_payment_sub_type(String scheme_payment_sub_type) {
		this.scheme_payment_sub_type = scheme_payment_sub_type;
	}

	public String getScheme_payment_type() {
		return scheme_payment_type;
	}

	public void setScheme_payment_type(String scheme_payment_type) {
		this.scheme_payment_type = scheme_payment_type;
	}
	
	public BankAccount getSponsor_party() {
		return sponsor_party;
	}

	public void setSponsor_party(BankAccount sponsor_party) {
		this.sponsor_party = sponsor_party;
	}

	public Bank getSponsor_bank() {
		return sponsor_bank;
	}

	public void setSponsor_bank(Bank sponsor_bank) {
		this.sponsor_bank = sponsor_bank;
	}

	public BankAccount getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(BankAccount beneficiary) {
		this.beneficiary = beneficiary;
	}

	public BankAccount getDebtor() {
		return debtor;
	}

	public void setDebtor(BankAccount debtor) {
		this.debtor = debtor;
	}	

}
