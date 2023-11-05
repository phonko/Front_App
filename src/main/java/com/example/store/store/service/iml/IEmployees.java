package com.example.store.store.service.iml;

import java.util.List;
import com.example.store.store.model.Employees;

public interface IEmployees {
	List<Employees> findAllEmployees();
	Employees findById(long id);
//	Employees findByEmailAndPassword(String user, String password);
	Employees save(Employees employees);
	void deleteById(long id);
}
