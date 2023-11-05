package com.example.store.store.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.store.store.model.Orders;
import com.example.store.store.repository.OrdersRepository;
import com.example.store.store.service.iml.IOrders;

@Service
public class OrdersService implements IOrders{
	
	OrdersRepository ordersRepository;
	
	public OrdersService(OrdersRepository ordersRepository) {
		// TODO Auto-generated constructor stub
		this.ordersRepository = ordersRepository;
	}
	public List<Orders> findAllOrders(){
		return ordersRepository.findAll();
	}
	public Orders findById(long id) {
		return ordersRepository.findById(id);
	}
//	public List<Orders> findAllByProductId(long id){
//		return ordersRepository.findAllByProductsId(id);
//	}
//	public List<Orders> findAllByEmployeeId(long id){
//		return ordersRepository.findAllByEmployeesId(id);
//	}
//	public List<Orders> findAllByCustomerId(long id){
//		return ordersRepository.findAllByCustomersId(id);
//	}
//	public Optional<Orders> findOptionalById(long id){
//		return ordersRepository.findOptionalById(id);
//	}
	public Orders save(Orders orders) {
		return ordersRepository.save(orders);
	}
	public void deleteById(long id) {
		ordersRepository.deleteById(id);
	}
}
