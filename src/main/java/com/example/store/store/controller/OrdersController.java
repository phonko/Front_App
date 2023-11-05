package com.example.store.store.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.store.business.OrdersBusiness;
import com.example.store.store.json.OrdersListJson;
import com.example.store.store.model.Orders;
import com.example.store.store.payload.OrdersPayload;
import com.example.store.store.repository.OrdersRepository;
import com.example.store.store.service.OrdersService;

@RestController
@RequestMapping("/api")
public class OrdersController {
	@Autowired
	OrdersService ordersService;
	
	@Autowired
	OrdersBusiness orderBusiness;
	
	public OrdersController(OrdersService ordersService,OrdersRepository ordersRepository) {
		// TODO Auto-generated constructor stub
		this.ordersService = ordersService;
	}
	@GetMapping("/orders/get/all")
	public List<OrdersListJson> getAllOrders(){
		return OrdersListJson.packJsons(ordersService.findAllOrders());
	}
	@GetMapping("/orders/get/{id}")
	public OrdersListJson getOrdersById(@PathVariable long id) {
		return OrdersListJson.packJson(ordersService.findById(id));
	}
	@PostMapping("/orders/save")
	public OrdersListJson saveoOrders(@RequestBody OrdersPayload od) {
		LocalDateTime createdAt = LocalDateTime.now();
		Orders orders = new Orders(
				od.getCustomer_id(), 
				od.getEmployee_id(),
				od.getProduct_id(),
				od.getOrder_total(),
				createdAt);
	    ordersService.save(orders);
	    return OrdersListJson.packJson(orders);
	}
	@PutMapping("/orders/update/{id}")
	public OrdersListJson updateOrders(@PathVariable long id, @RequestBody OrdersPayload ct) {
		Orders employees = ordersService.findById(id);
		employees.setCustomer_id(ct.getCustomer_id());
		employees.setEmployee_id(ct.getEmployee_id());
		employees.setProduct_id(ct.getProduct_id());
		employees.setOrder_total(ct.getOrder_total());
		ordersService.save(employees);
	    return OrdersListJson.packJson(employees);
	}
	@GetMapping("/orders/get/{id}/employees")
	public ResponseEntity<OrdersListJson> getOrderByEmployeeId(@PathVariable("id") long id) throws Exception{
		return ResponseEntity.ok(orderBusiness.getOrderByEmployee(id));
	}

	@GetMapping("/orders/get/{id}/customers")
	public ResponseEntity<OrdersListJson> getOrderByCustomerId(@PathVariable("id") long id) throws Exception{
		return ResponseEntity.ok(orderBusiness.getOrderByCustomer(id));
	}

	@GetMapping("/orders/get/{id}/products")
	public ResponseEntity<OrdersListJson> getOrderByProductId(@PathVariable("id") long id) throws Exception{
		return ResponseEntity.ok(orderBusiness.getOrderByProduct(id));
	}

//	@GetMapping("/orders/{id}/products")
//	public List<OrdersListJson> getOrdersAndProductsById(@PathVariable long id) {
//		return OrdersListJson.packJsons(ordersService.findAllByProductId(id));
//	}
//	@GetMapping("/orders/{id}/employees")
//	public List<OrdersListJson> getOrdersAndEmployeesById(@PathVariable long id) {
//		return OrdersListJson.packJsons(ordersService.findAllByEmployeeId(id));
//	}
//	@GetMapping("/orders/{id}/customer")
//	public List<OrdersListJson> getOrdersAndCustomerById(@PathVariable long id) {
//		return OrdersListJson.packJsons(ordersService.findAllByCustomerId(id));
//	}
}
