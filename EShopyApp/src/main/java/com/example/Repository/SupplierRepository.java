package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
	Supplier findByEmail(String email);
	boolean existsByEmail(String email);


}
