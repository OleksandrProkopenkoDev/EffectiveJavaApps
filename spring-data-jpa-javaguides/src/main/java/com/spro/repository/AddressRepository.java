package com.spro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spro.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
