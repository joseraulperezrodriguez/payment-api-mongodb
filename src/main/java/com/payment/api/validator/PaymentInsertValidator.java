package com.payment.api.validator;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.payment.api.data.repository.BankAccountRepository;
import com.payment.api.data.repository.BankRepository;
import com.payment.api.model.bussiness.Payment;

@Component
public class PaymentInsertValidator {
	
	@Autowired
	private BankRepository bankRepository;

	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	private boolean validOrganizationId(Payment payment) {
		return payment.getOrganization_id() != null && !payment.getOrganization_id().isEmpty();
	}
	
	private boolean validAmmount(Payment payment) {
		return payment.getAmount() != null && payment.getAmount() > 0;
	}
	
	private boolean validCurrency(Payment payment) {
		return payment.getCurrency() != null && !payment.getCurrency().isEmpty();
	}
	
	private boolean validEndToEndReference(Payment payment) {
		return payment.getEnd_to_end_reference() != null && !payment.getEnd_to_end_reference().isEmpty();
	}
	
	private boolean validFx(Payment payment) {
		return (payment.getFx() == null || payment.getFx().getId() == null);
	}
	
	private boolean validChargeInfo(Payment payment) {
		return (payment.getCharge_info() == null || payment.getCharge_info().getId() == null);
	}
	
	private boolean validNumericReference(Payment payment) {
		return payment.getNumeric_reference() != null && payment.getNumeric_reference() >= 0;
	}
	
	private boolean validPaymentPurpose(Payment payment) {
		return payment.getPayment_purpose() != null && !payment.getPayment_purpose().isEmpty();
	}
	
	private boolean validPaymentScheme(Payment payment) {
		return payment.getPayment_scheme() != null && !payment.getPayment_scheme().isEmpty();
	}
	
	private boolean validPaymementType(Payment payment) {
		return payment.getPayment_type() != null && payment.getPayment_type() >= 0;
	}
	
	private boolean validProcessingDate(Payment payment) {
		Instant now = Instant.now();
		boolean beforeOrEquals = payment.getProcessing_date().isBefore(now) || payment.getProcessing_date().equals(now);
		return payment.getProcessing_date() != null && beforeOrEquals;
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
	
	private boolean validBeneficiary(Payment payment) {
		return payment.getBeneficiary() != null && bankAccountRepository.exists(payment.getBeneficiary().getId());
	}
	
	private boolean validDebtor(Payment payment) {
		return payment.getDebtor() != null && bankAccountRepository.exists(payment.getDebtor().getId());
	}
	
	public boolean validate(Payment payment) {
		return payment.getId() == null &&
				validOrganizationId(payment) &&
				validAmmount(payment) && 
				validCurrency(payment) && 
				validEndToEndReference(payment) &&
				validFx(payment) && 
				validChargeInfo(payment) && 
				validNumericReference(payment) &&
				validPaymentPurpose(payment) && 
				validPaymentScheme(payment) &&
				validPaymementType(payment) &&
				validProcessingDate(payment) &&
				validReference(payment) &&
				validShemePaymentSubtype(payment) &&
				validShemePaymentType(payment) && 
				validSponsorBank(payment) &&
				validSponsorParty(payment) && 
				validBeneficiary(payment) &&
				validDebtor(payment); 
	}
	
}
