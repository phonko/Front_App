package com.example.store.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.store.model.Employees;

public interface EmployeesRepository extends JpaRepository<Employees,Long>{
	Employees findById(long id);
//	Employees findByEmailAndPassword(String user, String password);
}
