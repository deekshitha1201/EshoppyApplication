package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Entity.Customer;
import com.example.Repository.CustomerRespository;

@Service
public class CustomerImp implements CustomerService {
	@Autowired
	private CustomerRespository crepo;

	@Override
	public String createrecords(Customer customer) {
			Customer c= new Customer();
			c.setName(customer.getName());
			c.setEmail(customer.getEmail());
			c.setPhoneno(customer.getPhoneno());
			c.setPassword(customer.getPassword());
			crepo.save(c);
			return "registered successfully";
	}

	@Override
	public String login(Long id, String name, String password) {
		if(crepo.existsById(id))
		{
			Customer cc=crepo.findById(id).get();
			if(cc.getName().equals(name)&&cc.getPassword().equals(password))
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

}
