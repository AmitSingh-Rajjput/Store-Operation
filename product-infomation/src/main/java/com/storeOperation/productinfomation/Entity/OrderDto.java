package com.storeOperation.productinfomation.Entity;

import java.util.List;

public class OrderDto {
	
	private OrderTable order;
	
	private Long noOfProducts;
	
	private List<String> productId;
	
	private List<Long> quantity;
	
	private List<Float> listPrice;
	
	private List<Float> discount;

	public OrderTable getOrder() {
		return order;
	}

	public void setOrder(OrderTable order) {
		this.order = order;
	}

	public List<String> getProductId() {
		return productId;
	}

	public void setProductId(List<String> productId) {
		this.productId = productId;
	}

	public List<Long> getQuantity() {
		return quantity;
	}

	public void setQuantity(List<Long> quantity) {
		this.quantity = quantity;
	}

	public List<Float> getListPrice() {
		return listPrice;
	}

	public void setListPrice(List<Float> listPrice) {
		this.listPrice = listPrice;
	}

	public List<Float> getDiscount() {
		return discount;
	}

	public void setDiscount(List<Float> discount) {
		this.discount = discount;
	}

	public OrderDto(OrderTable order, List<String> productId, List<Long> quantity, List<Float> listPrice,
			List<Float> discount) {
		super();
		this.order = order;
		this.productId = productId;
		this.quantity = quantity;
		this.listPrice = listPrice;
		this.discount = discount;
	}

	public Long getNoOfProducts() {
		return noOfProducts;
	}

	public void setNoOfProducts(Long noOfProducts) {
		this.noOfProducts = noOfProducts;
	}

	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
