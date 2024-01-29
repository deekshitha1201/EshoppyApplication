package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Product;
import com.example.Service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService proserrepo;
	@PostMapping("/createnewproduct")
	public ResponseEntity<Product> createproduct(@RequestBody  Product product)
	{
		return new ResponseEntity<Product>(proserrepo.addproduct(product),HttpStatus.CREATED);
	}
	@GetMapping("/getallproducts")
	public ResponseEntity<List<Product>> getallrecord()
	{
		return new ResponseEntity<List<Product>>(proserrepo.getAll(),HttpStatus.OK);
	}
	@GetMapping("/price/{minPrice}/{maxPrice}")
	public ResponseEntity<List<Product>> productbypricernage(@PathVariable double minPrice,@PathVariable double maxPrice )
	{
		return new ResponseEntity<List<Product>>(proserrepo.getproductpricerange(minPrice, maxPrice),HttpStatus.OK);
	}
	@GetMapping("getbyid/{id}")
	public ResponseEntity<String> getbyidva(@PathVariable Long id)
	{
		return new ResponseEntity<String>(proserrepo.getproductbyid(id),HttpStatus.OK);
	}
	@DeleteMapping("deletebyid/{id}")
	public ResponseEntity<String> deteid(@PathVariable Long id)
	{
		return new ResponseEntity<String>(proserrepo.deltebyid(id),HttpStatus.OK);
	}
	@PutMapping("/updateprodBypr/{price}")
	public ResponseEntity<String> getByProduct(@PathVariable double price,@RequestBody Product product)
	{
		return new ResponseEntity<String>(proserrepo.updateproduct(product, price),HttpStatus.OK);
	}
	@PutMapping("/updateprodbyct/{category}")
	public ResponseEntity<String> getByProduct1(@PathVariable String category,@RequestBody Product product)
	{
		return new ResponseEntity<String>(proserrepo.updateproduct1(product, category),HttpStatus.OK);
	}


}
