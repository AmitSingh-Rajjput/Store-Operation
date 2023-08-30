package com.storeOperation.productinfomation.Entity;

import java.util.List;

public class ProductDisplayInfoDto {
	
	private Product product;
	private List<ProductDetails> productDetails;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}
	public ProductDisplayInfoDto(Product product, List<ProductDetails> productDetails) {
		super();
		this.product = product;
		this.productDetails = productDetails;
	}
	public ProductDisplayInfoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
