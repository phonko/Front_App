package com.example.store.store.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.store.store.json.CustomersListJson;
import com.example.store.store.model.Customers;
import com.example.store.store.payload.CustemersPayload;
import com.example.store.store.service.CustomersService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	CustomersService customersService;
	
	public CustomerController(CustomersService customersService) {
		// TODO Auto-generated constructor stub
		this.customersService = customersService;
	}
	@GetMapping("/customers")
	public List<CustomersListJson> getAllCustomer(){
		return CustomersListJson.packJsons(customersService.findAllCustomers());
	}
	@GetMapping("/customers/{id}")
	public CustomersListJson getCustomerById(@PathVariable long id) {
		return CustomersListJson.packJson(customersService.findById(id));
	}
	@PostMapping("/customers/save")
	public CustomersListJson saveCustomer(@RequestBody CustemersPayload ct) {
		LocalDateTime createdAt = LocalDateTime.now();
		Customers customers = new Customers(
				ct.getFirst_name(),
				ct.getLast_name(),
				ct.getC_user(),
				ct.getPassword(),
				createdAt);
		customersService.save(customers);
		return CustomersListJson.packJson(customers);
	}
	@PutMapping("/customers/update/{id}")
	public CustomersListJson updateCustomer(@PathVariable long id, @RequestBody CustemersPayload ct) {
		Customers customers = customersService.findById(id);
		customers.setFirst_name(ct.getFirst_name());
		customers.setLast_name(ct.getLast_name());
		customers.setC_user(ct.getC_user());
		customers.setPassword(ct.getPassword());
	    customersService.save(customers);
	    return CustomersListJson.packJson(customers);
	}
}
