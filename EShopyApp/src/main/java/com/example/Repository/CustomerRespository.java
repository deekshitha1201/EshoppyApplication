package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Customer;

public interface CustomerRespository extends JpaRepository<Customer, Long> {
	Customer findByEmail(String email);
	boolean existsByEmail(String email);

}
