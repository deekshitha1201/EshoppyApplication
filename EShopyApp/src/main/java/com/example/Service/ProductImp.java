package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Product;
import com.example.Repository.ProductRepository;

@Service
public class ProductImp implements ProductService {
	@Autowired
	private ProductRepository prorepo;

	@Override
	public Product addproduct(Product product) {
		// TODO Auto-generated method stub
		return prorepo.save(product);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return prorepo.findAll();
	}

	@Override
	public List<Product> getproductpricerange(double minPrice, double maxPrice) {
		// TODO Auto-generated method stub
		return prorepo.findByPriceBetween(minPrice, maxPrice);
	}

	@Override
	public String getproductbyid(Long id) {
		// TODO Auto-generated method stub
		Optional<Product> p=prorepo.findById(id);
		if(p.isPresent())
		{
			p.get();
			return p.toString();
		}else
		{
			return "product not found";
		}
	}
	@Override
	public String deltebyid(Long id) {
		if(prorepo.existsById(id)) {
			prorepo.deleteById(id);
			return "successfully deleted your product";
			
		}else {
			return "given product id is not found check once and try again";
		}
	}

	@Override
	public String updateproduct(Product product, double price) {
		Product p=prorepo.findByPrice(price).get(0);
		p.setPname(product.getPname());
		p.setCategory(product.getCategory());
		p.setPrice(product.getPrice());
		p.setDiscription(product.getDiscription());
		return "the product is updated by price and the updated details are : \n"+ prorepo.save(p).toString();
	}

	@Override
	public String updateproduct1(Product product, String category) {
		Product pd=prorepo.findByCategory(category).get(0);
		pd.setPname(product.getPname());
		pd.setPrice(product.getPrice());
		pd.setDiscription(product.getDiscription());
		pd.setCategory(product.getCategory());
		return "the product is updated by category and the updated details are : \n"+ prorepo.save(pd).toString();
	}

	

	
}
