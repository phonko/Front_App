package com.example.store.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.store.model.Customers;

public interface CustomersRepository extends JpaRepository<Customers,Long>{
	Customers findById(long id);
}
