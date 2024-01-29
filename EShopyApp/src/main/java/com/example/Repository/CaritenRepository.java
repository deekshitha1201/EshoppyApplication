package com.example.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.CartItem;

public interface CaritenRepository extends JpaRepository<CartItem, Long> {
	Optional<CartItem> findByProductId(Long productId);
	boolean existsByProductId(Long productId);


}
