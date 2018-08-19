package com.payment.api.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payment.api.model.bussiness.Payment;
import com.payment.api.model.ui.RESTPonse;
import com.payment.api.services.PaymentService;
import com.payment.api.validator.PaymentInsertValidator;
import com.payment.api.validator.PaymentUpdateValidator;

@RestController
@RequestMapping("/payment")
public class PaymentGateway {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private PaymentInsertValidator paymentInsertValidator;

	@Autowired
	private PaymentUpdateValidator paymentUpdateValidator;
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public RESTPonse insertPayment(@RequestBody Payment payment) {
		boolean valid = paymentInsertValidator.validate(payment);
		
		if(!valid) return new RESTPonse(false, "Invalid payment data. Please fix it");
		
		return paymentService.insertPayment(payment);
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public RESTPonse updatePayment(@RequestBody Payment payment) {
		boolean valid = paymentUpdateValidator.validate(payment);
		
		if(!valid) return new RESTPonse(false, "Invalid payment data for update. Please fix it");
		
		return paymentService.updatePayment(payment);
	}
	
	@RequestMapping(value="delete/{payment_id}", method=RequestMethod.POST)
	public RESTPonse deletePayment(@PathVariable("payment_id") String payment_id) {		
		return paymentService.deletePayment(payment_id);
	}
	
	@RequestMapping(value="get/{payment_id}", method=RequestMethod.GET)
	public RESTPonse getPayment(@PathVariable("payment_id") String payment_id) {
		return paymentService.getPayment(payment_id);
	}
	
	@RequestMapping(value="list/{debtor}/{page}/{size}", method=RequestMethod.GET)
	public RESTPonse listPaymentsByDebtor(@PathVariable("debtor")String debtor,@PathVariable("page") Integer page, @PathVariable("page") Integer size) {
		return paymentService.listPaymentsByDebtor(debtor,page, size);
	}
	
}
