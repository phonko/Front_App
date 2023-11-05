package com.example.store.store.payload;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductsPayload {
	private String product_name;
	private Integer price;
	private LocalDateTime created_at;
}
