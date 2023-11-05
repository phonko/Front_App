package com.example.store.store.service.iml;

import java.util.List;

import com.example.store.store.model.Customers;

public interface ICustomers {
	List<Customers> findAllCustomers();
	Customers findById(long id);
	Customers save(Customers customers);
	void deleteById(long id);
}
