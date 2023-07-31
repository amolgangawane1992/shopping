package com.inventory.shopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

	@Getter @Setter
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId", updatable = false, nullable = false)
	private int productId;
	
	@Column
	private String name;
	
	@Column
	private double price;
	
	
}
