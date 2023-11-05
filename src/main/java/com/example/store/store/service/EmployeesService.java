package com.example.store.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.store.store.model.Employees;
import com.example.store.store.repository.EmployeesRepository;
import com.example.store.store.service.iml.IEmployees;

@Service
public class EmployeesService implements IEmployees{
	
	EmployeesRepository employeesRepository;
	
	public EmployeesService(EmployeesRepository employeesRepository) {
		// TODO Auto-generated constructor stub
		this.employeesRepository = employeesRepository;
	}
	public List<Employees> findAllEmployees(){
		return employeesRepository.findAll();
	}
	public Employees findById(long id) {
		return employeesRepository.findById(id);
	}
//	public Employees findByEmailAndPassword(String user, String password) {
//		return employeesRepository.findByEmailAndPassword(user, password);
//	}
	public Employees save(Employees employees) {
		return employeesRepository.save(employees);
	}
	public void deleteById(long id) {
		employeesRepository.deleteById(id);
	}
}
