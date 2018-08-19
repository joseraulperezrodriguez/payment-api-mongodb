package com.payment.api.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.payment.api.model.bussiness.BankAccount;

@Repository
public interface BankAccountRepository extends MongoRepository<BankAccount, String> {

}
