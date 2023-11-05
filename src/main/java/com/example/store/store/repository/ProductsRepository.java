package com.example.store.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.store.model.Products;

public interface ProductsRepository extends JpaRepository<Products,Long>{
	Products findById(long id);
}
