package com.payment.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.payment.api.data.repository.PaymentRepository;
import com.payment.api.model.bussiness.ChargeInfo;
import com.payment.api.model.bussiness.Fx;
import com.payment.api.model.bussiness.Payment;
import com.payment.api.model.ui.RESTPonse;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
		
	@Autowired
	private ChargeInfoService chargeInfoService;
	
	@Autowired
	private FxService fxService;
	
	@Autowired
	private RemoveService removeService;
	
	public RESTPonse insertPayment(Payment payment) {

		ChargeInfo chargeInfo = payment.getCharge_info();
		Fx fx = payment.getFx();
		
		if(chargeInfo != null) {
			ChargeInfo savedChargeInfo = chargeInfoService.save(chargeInfo);
			if(savedChargeInfo != null && savedChargeInfo.getId() != null) {
				payment.setCharge_info(savedChargeInfo);
			} else {
				return new RESTPonse(false, "failed to save the payment resource");
			}
		}
		
		if(fx != null) {
			Fx savedFx = fxService.save(fx); 
			if(savedFx != null && savedFx.getId() != null) {
				payment.setFx(savedFx);
			} else {
				if(payment.getCharge_info() != null) {					
					removeService.tryRemove(payment.getCharge_info(), true);
				}
				return new RESTPonse(false, "failed to save the payment resource");
			}
		}
		
		Payment pay = this.save(payment);		
		
		if(pay == null || pay.getId() == null) {
			if(payment.getCharge_info() != null) {
				removeService.tryRemove(payment.getCharge_info(), true);
			}
			
			if(payment.getFx() != null) {
				removeService.tryRemove(payment.getFx(), true);
			}
			
			return new RESTPonse(false, "failed to insert payment");
			
		} else {			
			return new RESTPonse(true, payment);
		}

	}	
	
	public RESTPonse updatePayment(Payment payment) {
		
		Payment updated = this.save(payment);
		
		if(updated == null) return new RESTPonse(false, "failed updating");
		return new RESTPonse(true, updated);
	}
	
	public RESTPonse deletePayment(String paymentId) {
		Payment payment = paymentRepository.findOne(paymentId);
		if(payment == null) return new RESTPonse(false, "null payment, could not be removed");
				
		boolean deleted = removeService.tryRemove(payment, false);
		if(deleted) {
			if(payment.getCharge_info() != null) removeService.tryRemove(payment.getCharge_info(), true);
			if(payment.getFx() != null) removeService.tryRemove(payment.getFx(), true);

			return new RESTPonse(true, payment);
		} else {
			return new RESTPonse(false, "failed to remove");
		}
				
	}
	
	public RESTPonse getPayment(String id) {
		
		Payment payment = paymentRepository.findOne(id);
		if(payment != null) {
			return new RESTPonse(true, payment);
		} else {
			return new RESTPonse(false, "payment not found");
		}
	}
	
	public RESTPonse listPaymentsByDebtor(String debtor, int page, int size) {
		try {
			Page<Payment> paymentPage = paymentRepository.findByDebtor(debtor, new PageRequest(page, size));
			List<Payment> payments = paymentPage.getContent();
			return new RESTPonse(true, payments);
		} catch(Exception e) {
			return new RESTPonse(false, "error quering data");
		}
		
	}
	
	public Payment save(Payment payment) {
		if(payment == null) return null;
		
		try {
			return paymentRepository.save(payment);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
