package com.example.store.store.service.iml;

import java.util.List;
import com.example.store.store.model.Orders;

public interface IOrders {
	List<Orders> findAllOrders();
	Orders findById(long id);
//	List<Orders> findAllByProductId(long id); //10
//	List<Orders> findAllByEmployeeId(long id); //11
//	List<Orders> findAllByCustomerId(long id); //12
//	Optional<Orders> findOptionalById(long id);
	Orders save(Orders erders);
	void deleteById(long id);
}
