package com.example.store.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.store.store.model.Products;
import com.example.store.store.repository.ProductsRepository;
import com.example.store.store.service.iml.IProducts;

@Service
public class ProductsService implements IProducts{

	ProductsRepository productsRepository;
	
	public ProductsService(ProductsRepository productsRepository) {
		// TODO Auto-generated constructor stub
		this.productsRepository = productsRepository;
	}
	public List<Products> findAllProducts(){
		return productsRepository.findAll();
	}
	public Products findById(long id) {
		return productsRepository.findById(id);
	}
	public Products save(Products products) {
		return productsRepository.save(products);
	}
	public void deleteById(long id) {
		productsRepository.deleteById(id);
	}
}
