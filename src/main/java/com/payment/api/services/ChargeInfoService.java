package com.payment.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.api.data.repository.ChargeInfoRepository;
import com.payment.api.model.bussiness.ChargeInfo;

@Service
public class ChargeInfoService {

	@Autowired
	private ChargeInfoRepository chargeInfoRepository;
	
	
	public ChargeInfo save(ChargeInfo chargeInfo) {
		if(chargeInfo == null) return null;
		try {
			return  chargeInfoRepository.save(chargeInfo);
		} catch(Exception e) {
			return null;
		}
	}
	
}
