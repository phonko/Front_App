package com.example.store.store.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.store.store.json.EmployeesListJson;
import com.example.store.store.model.Employees;
import com.example.store.store.payload.EmployeesPayload;
import com.example.store.store.service.EmployeesService;

@RestController
@RequestMapping("/api")
public class EmployeesController {

	EmployeesService employeesService;
	
	public EmployeesController(EmployeesService employeesService) {
		// TODO Auto-generated constructor stub
		this.employeesService = employeesService;
	}
	
	@GetMapping("/employees")
	public List<EmployeesListJson> getAllEmployees(){
		return EmployeesListJson.packJsons(employeesService.findAllEmployees());
	}
	@GetMapping("/employees/{id}")
	public EmployeesListJson getEmployeesById(@PathVariable long id) {
		return EmployeesListJson.packJson(employeesService.findById(id));
	}
	@PostMapping("/employees/save")
	public EmployeesListJson saveEmployees(@RequestBody EmployeesPayload ep) {
		LocalDateTime createdAt = LocalDateTime.now();
		Employees employees = new Employees(
				ep.getFirst_name(),
				ep.getLast_name(),
				ep.getUser(),
				ep.getPassword(),
				createdAt);
		employeesService.save(employees);
		return EmployeesListJson.packJson(employees);
	}
	@PutMapping("/employees/update/{id}")
	public EmployeesListJson updateEmployees(@PathVariable long id, @RequestBody EmployeesPayload ct) {
		Employees employees = employeesService.findById(id);
		employees.setFirst_name(ct.getFirst_name());
		employees.setLast_name(ct.getLast_name());
		employees.setUser(ct.getUser());
		employees.setPassword(ct.getPassword());
		employeesService.save(employees);
	    return EmployeesListJson.packJson(employees);
	}
}
