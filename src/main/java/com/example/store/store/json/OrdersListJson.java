package com.example.store.store.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.store.store.model.Customers;
import com.example.store.store.model.Employees;
import com.example.store.store.model.Orders;
import com.example.store.store.model.Products;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrdersListJson {
	
	private long id;
	private Customers customer_id;
	private Employees employee_id;
	private Products product_id;
	private Integer order_total;
	private LocalDateTime created_at;
	
	public static OrdersListJson packJson(Orders orders) {
		OrdersListJson olj = new OrdersListJson();
		olj.setId(orders.getId());
		olj.setCustomer_id(orders.getCustomer_id());
		olj.setEmployee_id(orders.getEmployee_id());
		olj.setProduct_id(orders.getProduct_id());
		olj.setOrder_total(orders.getOrder_total());
		olj.setCreated_at(orders.getCreated_at());
		return olj;
	}
	public static List<OrdersListJson> packJsons(List<Orders>od){
		List<OrdersListJson> olj = new ArrayList<OrdersListJson>();
		for(Orders orders : od) {
			olj.add(packJson(orders));
		}
		return olj;
	}
}
