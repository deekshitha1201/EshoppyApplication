package com.example.Service;

import org.springframework.stereotype.Service;

import com.example.Entity.Customer;

@Service
public interface CustomerService {
	String createrecords(Customer customer);
	String login(Long id, String name, String password);

}
