package com.payment.api.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.payment.api.model.bussiness.ChargeInfo;

public interface ChargeInfoRepository extends MongoRepository<ChargeInfo, String>, CrudRepository<ChargeInfo, String> { }
