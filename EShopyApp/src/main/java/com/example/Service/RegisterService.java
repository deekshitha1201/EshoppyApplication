package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Entity.Customer;
import com.example.Repository.CustomerRespository;


@Service
public class RegisterService {
	@Autowired
	private CustomerRespository crepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Customer findByEmail(String email) {
		return crepo.findByEmail(email);
		}
	public ResponseEntity<String> savecustomer(Customer customer) {
		 
	     if (crepo.existsByEmail(customer.getEmail())) {
	         return ResponseEntity.badRequest().body("Email already registered");

	     }

	   	     customer.setPassword(passwordEncoder.encode(customer.getPassword()));
	        	     crepo.save(customer);
	     return ResponseEntity.ok("Customer registered successfully");

	}

}
