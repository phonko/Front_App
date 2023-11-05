package com.example.store.store.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.store.store.json.OrdersListJson;
import com.example.store.store.service.OrdersService;

@Service
public class OrdersBusiness {
	
	 @Autowired
		OrdersService OrdersService;

	    public List<OrdersListJson> getListOrder() {
			return OrdersListJson.packJsons(OrdersService.findAllOrders());
		}

	    public OrdersListJson getOrderByEmployee(long id){
	        return OrdersListJson.packJson(OrdersService.findById(id));
	    }

	    public OrdersListJson getOrderByCustomer(long id){
	        return OrdersListJson.packJson(OrdersService.findById(id));
	    }

	    public OrdersListJson getOrderByProduct(long id){
	        return OrdersListJson.packJson(OrdersService.findById(id));
	    }
}
