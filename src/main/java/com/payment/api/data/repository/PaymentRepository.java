package com.payment.api.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.payment.api.model.bussiness.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String>, CrudRepository<Payment, String>, PagingAndSortingRepository<Payment, String> {

	public Page<Payment> findByDebtor(String id, Pageable page);
	
}
