package com.example.Service;

import org.springframework.stereotype.Service;

import com.example.Entity.Product;
import com.example.Entity.Supplier;

@Service
public interface SupplierService {
	String createrecords(Supplier supplier);
	String login(Long id,String name,String password);
	String addProductForSupplier(Long sellerId, Product product);

	

}
