package com.example.store.store.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
//@RequiredArgsConstructor
@ToString
@Entity(name= "Customers")
@Table(
		name = "Customers",
		uniqueConstraints = {
				@UniqueConstraint(name = "customers_user_unique", columnNames = "c_user")
		}
)
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "first_name", nullable = false)
	private String first_name;
	
	@Column(name = "last_name", nullable = false)
	private String last_name;
	
	@Column(name = "c_user", unique = true, nullable = false)
	private String c_user;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, 
	updatable = false, insertable = false,
	columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created_at;
	
	public Customers() {
		// TODO Auto-generated constructor stub
	}
	public Customers(String first_name,String last_name,String c_user,String password,LocalDateTime created_at) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.c_user = c_user;
		this.password = password;
		this.created_at = created_at;
	}
}
