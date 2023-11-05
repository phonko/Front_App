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
@Entity(name= "Employees")
@Table(
		name = "Employees",
		uniqueConstraints = {
				@UniqueConstraint(name = "employees_user_unique", columnNames = "user")
		}
)
public class Employees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "first_name", nullable = false)
	private String first_name;
	
	@Column(name = "last_name", nullable = false)
	private String last_name;
	
	@Column(name = "user", unique = true, nullable = false)
	private String user;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, 
	updatable = false, insertable = false,
	columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created_at;
	
	public Employees() {
		// TODO Auto-generated constructor stub
	}
	public Employees(String first_name,String last_name,String user,String password,LocalDateTime created_at) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.user = user;
		this.password = password;
		this.created_at = created_at;
	}
}
