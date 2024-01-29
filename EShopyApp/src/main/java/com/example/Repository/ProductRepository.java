package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByPriceBetween(double minPrice,double maxPrice);
	List<Product> findByPrice(double price);
	List<Product> findByCategory(String category);
}
