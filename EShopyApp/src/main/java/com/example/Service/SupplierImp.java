package com.example.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Customer;
import com.example.Entity.Product;
import com.example.Entity.Supplier;
import com.example.Repository.ProductRepository;
import com.example.Repository.SupplierRepository;

@Service
public class SupplierImp implements SupplierService {
	@Autowired
	private SupplierRepository suprepo;
	@Autowired
	private ProductRepository prorepo;

	@Override
	public String createrecords(Supplier supplier) {
		Supplier s= new Supplier();
		s.setName(supplier.getName());
		s.setEmail(supplier.getEmail());
		s.setPhoneno(supplier.getPhoneno());
		s.setPassword(supplier.getPassword());
		suprepo.save(s);
		return "saved successfully";
		
	}

	@Override
	public String login(Long id, String name, String password) {
		if(suprepo.existsById(id))
		{
			Supplier ss=suprepo.findById(id).get();
			if(ss.getName().equals(name)&&ss.getPassword().equals(password))
			{
				return "login successfully";
			}
			else
			{
				return "invalid username or password";
			}
		}
		return "id not registered";
	}

	public String addProductForSupplier(Long sellerId, Product product) {
		Optional<Supplier> optionalSupplier = suprepo.findById(sellerId);
	    if (optionalSupplier.isPresent()) {
	        Supplier seller = optionalSupplier.get();
	        product.setSupplier(seller);
	        seller.addProduct(product);
	        // Save both the seller and the product
	        suprepo.save(seller);
	        prorepo.save(product);
	        return "Product added by the seller successfully";
	    }
	    else
	    {
	    	return "Supplier not found";
	    }
	}

	}


