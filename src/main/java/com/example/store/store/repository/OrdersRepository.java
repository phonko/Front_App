package com.example.store.store.repository;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.store.store.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long>{
	Orders findById(long id);
//	List<Orders> findAllByProductsId(long id); //10
//	List<Orders> findAllByEmployeesId(long id); //11
//	List<Orders> findAllByCustomersId(long id); //12
//	Optional<Orders> findOptionalById(long id);
}
