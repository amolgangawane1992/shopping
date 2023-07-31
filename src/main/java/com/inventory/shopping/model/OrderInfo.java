package com.inventory.shopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class OrderInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	
	@Column
	private String item;
	
	@Column
	private double price;
	
	@Column
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "CUST_ID")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Customer customer;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public OrderInfo() {}

	public OrderInfo(int orderId, String item, double price, String status, Customer customer) {
		super();
		this.orderId = orderId;
		this.item = item;
		this.price = price;
		this.status = status;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", item=" + item + ", price=" + price + ", status=" + status
				+ ", customer=" + customer + "]";
	}
	
	
}
