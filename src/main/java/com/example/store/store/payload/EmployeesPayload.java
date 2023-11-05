package com.example.store.store.payload;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeesPayload {
	private String first_name;
	private String last_name;
	private String user;
	private String password;
	private LocalDateTime created_at;
}
