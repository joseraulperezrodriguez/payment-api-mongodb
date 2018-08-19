package com.payment.api.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.payment.api.model.bussiness.Fx;

@Repository
public interface FxRepository extends MongoRepository<Fx, String> {

}
