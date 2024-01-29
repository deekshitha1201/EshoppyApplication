package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
