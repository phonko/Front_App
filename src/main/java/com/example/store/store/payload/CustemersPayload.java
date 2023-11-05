package com.example.store.store.payload;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustemersPayload {
	private String first_name;
	private String last_name;
	private String c_user;
	private String password;
	private LocalDateTime created_at;
}
