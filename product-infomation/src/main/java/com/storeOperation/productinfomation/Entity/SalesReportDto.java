package com.storeOperation.productinfomation.Entity;

import java.util.List;

public class SalesReportDto {
	
	private OrderTable order;
	private List<OrderItems> orderItems;
	public OrderTable getOrder() {
		return order;
	}
	public void setOrder(OrderTable order) {
		this.order = order;
	}
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	public SalesReportDto(OrderTable order, List<OrderItems> orderItems) {
		super();
		this.order = order;
		this.orderItems = orderItems;
	}
	public SalesReportDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
