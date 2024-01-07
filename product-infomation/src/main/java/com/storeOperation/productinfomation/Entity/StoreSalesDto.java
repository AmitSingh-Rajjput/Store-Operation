package com.storeOperation.productinfomation.Entity;

public class StoreSalesDto {
	
	private float grossSales;
	
	private float netSales;
	
	private float discount;
	
	private float returnOrder;

	public float getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(float grossSales) {
		this.grossSales = grossSales;
	}

	public float getNetSales() {
		return netSales;
	}

	public void setNetSales(float netSales) {
		this.netSales = netSales;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount2) {
		this.discount = discount2;
	}

	public float getReturnOrder() {
		return returnOrder;
	}

	public void setReturnOrder(float returnOrder) {
		this.returnOrder = returnOrder;
	}

	public StoreSalesDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StoreSalesDto(float grossSales, float netSales, float discount, float returnOrder) {
		super();
		this.grossSales = grossSales;
		this.netSales = netSales;
		this.discount = discount;
		this.returnOrder = returnOrder;
	}

}
