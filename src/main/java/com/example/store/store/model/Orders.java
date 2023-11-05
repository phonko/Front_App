package com.example.store.store.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
//@RequiredArgsConstructor
@ToString
@Entity(name= "Orders")
@Table(
		name = "Orders"
)
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id",referencedColumnName = "id" ,nullable = false)
	@Fetch(FetchMode.JOIN)
	private Customers customer_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id",referencedColumnName = "id" ,nullable = false)
	@Fetch(FetchMode.JOIN)
	private Employees employee_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id",referencedColumnName = "id" ,nullable = false)
	@Fetch(FetchMode.JOIN)
	private Products product_id;
	
	@Column(name = "order_total", nullable = false)
	private Integer order_total;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, 
	updatable = false, insertable = false,
	columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created_at;
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}
	public Orders(Customers customer_id,Employees employee_id,Products product_id,Integer order_total,LocalDateTime created_at) {
		super();
		this.customer_id = customer_id;
		this.employee_id = employee_id;
		this.product_id = product_id;
		this.order_total = order_total;
		this.created_at = created_at;
	}
}
