package com.payment.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.api.data.repository.FxRepository;
import com.payment.api.model.bussiness.Fx;

@Service
public class FxService {

	@Autowired
	private FxRepository fxRepository;
			
	public Fx save(Fx fx) {
		if(fx == null) return null;		
		try {
			return fxRepository.save(fx);
		} catch (Exception e) {
			return null;
		}
	}
	
}
