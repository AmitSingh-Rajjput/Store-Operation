package com.storeOperation.productinfomation.Entity;

import java.util.List;

public class ProductDisplayPromotion {
	
	private Product product;
	private List<PromotionItemList> promoItemList;
	public ProductDisplayPromotion(Product product,
			List<PromotionItemList> promoItemList) {
		super();
		this.product = product;
		this.promoItemList = promoItemList;
	}
	public ProductDisplayPromotion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public List<PromotionItemList> getPromoItemList() {
		return promoItemList;
	}
	public void setPromoItemList(List<PromotionItemList> promoItemList) {
		this.promoItemList = promoItemList;
	}
	
	

}
