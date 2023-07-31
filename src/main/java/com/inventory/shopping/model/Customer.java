package com.inventory.shopping.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Customer {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int custId;
	
	@Column
	private String name;
	
	@Column
	private int age;
	
	@Column
	private String city;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	Collection<OrderInfo> orderList = new ArrayList<>();

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Collection<OrderInfo> getOrderList() {
		return orderList;
	}

	public void setOrderList(Collection<OrderInfo> orders) {
		
		
		this.orderList = orders;
		for(OrderInfo order : orderList) {
			order.setCustomer(this);
		}
	}
	
	
	
}
