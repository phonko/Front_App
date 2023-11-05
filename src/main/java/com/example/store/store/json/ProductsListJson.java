package com.example.store.store.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.store.store.model.Products;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductsListJson {
	
	private long id;
	private String product_name;
	private Integer price;
	private LocalDateTime created_at;
	
	public static ProductsListJson packJson(Products products) {
		ProductsListJson plj = new ProductsListJson();
		plj.setId(products.getId());
		plj.setProduct_name(products.getProduct_name());
		plj.setPrice(products.getPrice());
		plj.setCreated_at(products.getCreated_at());
		return plj;
	}
	public static List<ProductsListJson> packJsons(List<Products>pd){
		List<ProductsListJson> plj = new ArrayList<ProductsListJson>();
		for(Products products : pd) {
			plj.add(packJson(products));
		}
		return plj;
	}
}
