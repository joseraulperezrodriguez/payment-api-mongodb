package com.payment.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.WriteResult;
import com.payment.api.model.bussiness.IPDocument;

@Service
public class RemoveService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public boolean tryRemove(IPDocument t, boolean async) {
		try {
			WriteResult result = mongoTemplate.remove(t, t.collection());
			if(result.getN() > 0) return true;
			else if(async) {
				//TODO insert to delete				
			}
			return false;
		} catch (Exception e) {
			if(async)   ; //TODO insert to delete
			return false;
		}
	}
	
}
