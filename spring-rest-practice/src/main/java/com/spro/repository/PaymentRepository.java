package com.spro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spro.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
