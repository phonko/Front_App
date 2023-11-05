package com.example.store.store.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
//@RequiredArgsConstructor
@ToString
@Entity(name= "Products")
@Table(
		name = "Products"
)
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "product_name", nullable = false)
	private String product_name;
	
	@Column(name = "price", nullable = false)
	private Integer price;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, 
	updatable = false, insertable = false,
	columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created_at;
	
	public Products() {
		// TODO Auto-generated constructor stub
	}
	public Products(String product_name,Integer price,LocalDateTime created_at) {
		super();
		this.product_name = product_name;
		this.price = price;
		this.created_at = created_at;
	}
}
