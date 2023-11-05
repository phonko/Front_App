package com.example.store.store.service.iml;

import java.util.List;

import com.example.store.store.model.Products;

public interface IProducts {
	List<Products> findAllProducts();
	Products findById(long id);
	Products save(Products rroducts);
	void deleteById(long id);
}
