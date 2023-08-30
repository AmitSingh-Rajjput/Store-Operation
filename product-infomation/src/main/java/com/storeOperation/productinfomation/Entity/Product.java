package com.storeOperation.productinfomation.Entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String productName;
	
	private String productSku;
	
	private String productCatogary;
	
	private String productType;
	
	private String productImageUrl;
	
	private String productPurchasePrice;
	
	private String productSellingPrice;
	
	private Long shelfNo;
	
	
	private Long previousSale;
	
	
	public String getProductImageUrl() {
		return productImageUrl;
	}


	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}


	public String getProductPurchasePrice() {
		return productPurchasePrice;
	}


	public void setProductPurchasePrice(String productPurchasePrice) {
		this.productPurchasePrice = productPurchasePrice;
	}


	public String getProductSellingPrice() {
		return productSellingPrice;
	}


	public void setProductSellingPrice(String productSellingPrice) {
		this.productSellingPrice = productSellingPrice;
	}


	public Product(Long id, String productName, String productSku, String productCatogary, String productType,
			String productImageUrl, String productPurchasePrice, String productSellingPrice, Long shelfNo,
			Long previousSale) {
		super();
		this.id = id;
		this.productName = productName;
		this.productSku = productSku;
		this.productCatogary = productCatogary;
		this.productType = productType;
		this.productImageUrl = productImageUrl;
		this.productPurchasePrice = productPurchasePrice;
		this.productSellingPrice = productSellingPrice;
		this.shelfNo = shelfNo;
		this.previousSale = previousSale;
	}


	public String getProductSku() {
		return productSku;
	}


	public void setProductSku(String productSku) {
		this.productSku = productSku;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCatogary() {
		return productCatogary;
	}

	public void setProductCatogary(String productCatogary) {
		this.productCatogary = productCatogary;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Long getShelfNo() {
		return shelfNo;
	}

	public void setShelfNo(Long shelfNo) {
		this.shelfNo = shelfNo;
	}

	public Long getPreviousSale() {
		return previousSale;
	}

	public void setPreviousSale(Long previousSale) {
		this.previousSale = previousSale;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
