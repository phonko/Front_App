package com.example.store.store.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.store.store.model.Customers;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomersListJson {

	private long id;
	private String first_name;
	private String last_name;
	private String c_user;
	private String password;
	private LocalDateTime created_at;
	
	public static CustomersListJson packJson(Customers customers) {
		CustomersListJson clj = new CustomersListJson();
		clj.setId(customers.getId());
		clj.setFirst_name(customers.getFirst_name());
		clj.setLast_name(customers.getLast_name());
		clj.setC_user(customers.getC_user());
		clj.setPassword(customers.getPassword());
		clj.setCreated_at(customers.getCreated_at());
		return clj;
	}
	public static List<CustomersListJson> packJsons(List<Customers>ct){
		List<CustomersListJson> clj = new ArrayList<CustomersListJson>();
		for(Customers customers : ct) {
			clj.add(packJson(customers));
		}
		return clj;
	}
}
