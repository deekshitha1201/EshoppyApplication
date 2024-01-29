package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Entity.Product;

@Service
public interface ProductService {
	
	Product addproduct(Product product);
	List<Product> getAll();
	List<Product> getproductpricerange(double minPrice, double maxPrice);
	String getproductbyid(Long id);
	String deltebyid(Long id);
	String updateproduct(Product product, double price);
	String updateproduct1(Product product, String category);
	


	

}
