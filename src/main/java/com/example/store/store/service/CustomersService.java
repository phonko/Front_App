package com.example.store.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.store.store.model.Customers;
import com.example.store.store.repository.CustomersRepository;
import com.example.store.store.service.iml.ICustomers;

@Service
public class CustomersService implements ICustomers{
	
	CustomersRepository customersRepository;
	
	public CustomersService(CustomersRepository customersRepository) {
		// TODO Auto-generated constructor stub
		this.customersRepository = customersRepository;
	}
	public List<Customers> findAllCustomers(){
		return customersRepository.findAll();
	}
	public Customers findById(long id) {
		return customersRepository.findById(id);
	}
	public Customers save(Customers customers) {
		return customersRepository.save(customers);
	}
	public void deleteById(long id) {
		customersRepository.deleteById(id);
	}
}
