package com.payment.api.validator;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.payment.api.data.repository.BankAccountRepository;
import com.payment.api.data.repository.BankRepository;
import com.payment.api.data.repository.PaymentRepository;
import com.payment.api.model.bussiness.Payment;

@Component
public class PaymentUpdateValidator {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private BankAccountRepository bankAccountRepository;
		
	//Not allow to update	
	private boolean validAmmount(Payment payment, Payment original) {
		if(payment.getAmount() == null) return false;
		return ((double)payment.getAmount() == (double)original.getAmount());
	}
	
	private boolean validCurrency(Payment payment, Payment original) {
		if(payment.getCurrency() == null) return false;
		return payment.getCurrency().equals(original.getCurrency());
	}
	
	private boolean validFx(Payment payment, Payment original) {
		if(original.getFx() == null) return payment.getFx() == null;
		return payment.getFx().getId().equals(original.getFx().getId());
	}
	
	private boolean validChargeInfo(Payment payment, Payment original) {
		if(payment.getCharge_info() == null) return original.getCharge_info() == null;
		return payment.getCharge_info().getId().equals(original.getCharge_info().getId());
	}
	
	private boolean validPaymentScheme(Payment payment, Payment original) {
		if(payment.getPayment_scheme() == null) return false;
		return payment.getPayment_scheme().equals(original.getPayment_scheme());
	}
	
	private boolean validProcessingDate(Payment payment, Payment original) {
		if(payment.getProcessing_date() == null) return false;
					
		ZonedDateTime zdt = ZonedDateTime.ofInstant(payment.getProcessing_date(), ZoneId.systemDefault());
		ZonedDateTime zdt1 = ZonedDateTime.ofInstant(original.getProcessing_date(), ZoneId.systemDefault());
		
		GregorianCalendar date = GregorianCalendar.from(zdt);
		GregorianCalendar date1 = GregorianCalendar.from(zdt1);
		
		int year = date.get(GregorianCalendar.YEAR);
		int month = date.get(GregorianCalendar.MONTH);
		int day = date.get(GregorianCalendar.DATE);
		
		int year1 = date1.get(GregorianCalendar.YEAR);
		int month1 = date1.get(GregorianCalendar.MONTH);
		int day1 = date1.get(GregorianCalendar.DATE);
		
		return (year == year1 && month == month1 && day == day1);
	}
	
	private boolean validBeneficiary(Payment payment, Payment original) {
		if(payment.getBeneficiary() == null) return false;
		
		return payment.getBeneficiary().getId().equals(original.getBeneficiary().getId());
	}
	
	private boolean validDebtor(Payment payment, Payment original) {
		if(payment.getDebtor() == null) return false;		
		
		return payment.getDebtor().getId().equals(original.getDebtor().getId());
	}	
	
	//Can be updated
	private boolean validOrganizationId(Payment payment) {
		return payment.getOrganization_id() != null && !payment.getOrganization_id().isEmpty();
	}
		
	private boolean validEndToEndReference(Payment payment) {
		return payment.getEnd_to_end_reference() != null && !payment.getEnd_to_end_reference().isEmpty();
	}
	
	private boolean validNumericReference(Payment payment) {
		return payment.getNumeric_reference() != null && payment.getNumeric_reference() >= 0;
	}
	
	private boolean validPaymentPurpose(Payment payment) {
		return payment.getPayment_purpose() != null && !payment.getPayment_purpose().isEmpty();
	}
	
	private boolean validPaymementType(Payment payment) {
		return payment.getPayment_type() != null && payment.getPayment_type() >= 0;
	}
		
	private boolean validReference(Payment payment) {
		return payment.getReference() != null && !payment.getReference().isEmpty();
	}
	
	private boolean validShemePaymentSubtype(Payment payment) {
		return payment.getScheme_payment_sub_type() != null && !payment.getScheme_payment_sub_type().isEmpty();
	}
	
	private boolean validShemePaymentType(Payment payment) {
		return payment.getScheme_payment_type() != null && !payment.getScheme_payment_type().isEmpty();
	}
	
	private boolean validSponsorBank(Payment payment) {
		return payment.getSponsor_bank() != null && bankRepository.exists(payment.getSponsor_bank().getId());
	}
	
	private boolean validSponsorParty(Payment payment) {
		return payment.getSponsor_party() != null && bankAccountRepository.exists(payment.getSponsor_party().getId());
	}
	
	public boolean validate(Payment payment) {
		
		Payment original = paymentRepository.findOne(payment.getId());
		
		return payment.getId() != null &&
				original != null &&
				validOrganizationId(payment) &&
				validAmmount(payment, original) &&
				validCurrency(payment, original) &&
				validEndToEndReference(payment) &&
				validFx(payment, original) && 
				validChargeInfo(payment, original) &&
				validNumericReference(payment) &&
				validPaymentPurpose(payment) && 
				validPaymentScheme(payment, original) &&
				validPaymementType(payment) &&
				validProcessingDate(payment, original) &&
				validReference(payment) &&
				validShemePaymentSubtype(payment) &&
				validShemePaymentType(payment) && 
				validSponsorBank(payment) &&
				validSponsorParty(payment) && 
				validBeneficiary(payment, original) &&
				validDebtor(payment, original);
	}
		
}
