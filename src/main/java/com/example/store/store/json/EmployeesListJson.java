package com.example.store.store.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.example.store.store.model.Employees;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeesListJson {
	
	private long id;
	private String first_name;
	private String last_name;
	private String user;
	private String password;
	private LocalDateTime created_at;
	
	public static EmployeesListJson packJson(Employees employees) {
		EmployeesListJson mlj = new EmployeesListJson();
		mlj.setId(employees.getId());
		mlj.setFirst_name(employees.getFirst_name());
		mlj.setLast_name(employees.getLast_name());
		mlj.setUser(employees.getUser());
		mlj.setPassword(employees.getPassword());
		mlj.setCreated_at(employees.getCreated_at());
		return mlj;
	}
	public static List<EmployeesListJson> packJsons(List<Employees>ep){
		List<EmployeesListJson> mlj = new ArrayList<EmployeesListJson>();
		for(Employees employees : ep) {
			mlj.add(packJson(employees));
		}
		return mlj;
	}
}
