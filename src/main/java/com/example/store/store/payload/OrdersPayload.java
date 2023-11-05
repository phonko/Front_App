package com.example.store.store.payload;

import java.time.LocalDateTime;

import com.example.store.store.model.Customers;
import com.example.store.store.model.Employees;
import com.example.store.store.model.Products;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrdersPayload {
	private Customers customer_id;
	private Employees employee_id;
	private Products product_id;
	private Integer order_total;
	private LocalDateTime created_at;
}
