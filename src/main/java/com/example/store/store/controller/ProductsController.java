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
import com.example.store.store.json.ProductsListJson;
import com.example.store.store.model.Products;
import com.example.store.store.payload.ProductsPayload;
import com.example.store.store.service.ProductsService;

@RestController
@RequestMapping("/api")
public class ProductsController {
	
	ProductsService productsService;
	
	public ProductsController(ProductsService productsService) {
		// TODO Auto-generated constructor stub
		this.productsService = productsService;
	}
	@GetMapping("/products")
	public List<ProductsListJson> getAllProducts(){
		return ProductsListJson.packJsons(productsService.findAllProducts());
	}
	@GetMapping("/products/{id}")
	public ProductsListJson getProductsById(@PathVariable long id) {
		return ProductsListJson.packJson(productsService.findById(id));
	}
	@PostMapping("/products/save")
	public ProductsListJson saveProducts(@RequestBody ProductsPayload pd) {
		LocalDateTime createdAt = LocalDateTime.now();
		Products products = new Products(
				pd.getProduct_name(),
				pd.getPrice(),
				createdAt);
		productsService.save(products);
		return ProductsListJson.packJson(products);
	}
	@PutMapping("/products/update/{id}")
	public ProductsListJson updateProducts(@PathVariable long id, @RequestBody ProductsPayload pd) {
	    Products products = productsService.findById(id);
	    products.setProduct_name(pd.getProduct_name());
	    products.setPrice(pd.getPrice());
	    productsService.save(products);
	    return ProductsListJson.packJson(products);
	}

}
