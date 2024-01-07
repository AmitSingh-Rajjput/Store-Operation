package com.storeOperation.productinfomation.Entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "prod_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "order_id", nullable = false)
//	@OnDelete(action = OnDeleteAction.CASCADE)
	private OrderTable order;
	
	private Long qunatity;
	
	private Float listPrice;
	
	public OrderItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Float discount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderTable getOrder() {
		return order;
	}

	public void setOrder(OrderTable order) {
		this.order = order;
	}

	public Long getQunatity() {
		return qunatity;
	}

	public void setQunatity(Long qunatity) {
		this.qunatity = qunatity;
	}

	public Float getListPrice() {
		return listPrice;
	}

	public void setListPrice(Float listPrice) {
		this.listPrice = listPrice;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public OrderItems(Product product, OrderTable order, Long qunatity, Float listPrice, Float discount) {
		super();
		this.product = product;
		this.order = order;
		this.qunatity = qunatity;
		this.listPrice = listPrice;
		this.discount = discount;
	}

	public OrderItems(Long id, Product product, OrderTable order, Long qunatity, Float listPrice, Float discount) {
		super();
		this.id = id;
		this.product = product;
		this.order = order;
		this.qunatity = qunatity;
		this.listPrice = listPrice;
		this.discount = discount;
	}

}
