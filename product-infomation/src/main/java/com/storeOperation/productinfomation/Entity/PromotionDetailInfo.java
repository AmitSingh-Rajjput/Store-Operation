package com.storeOperation.productinfomation.Entity;

import java.util.List;

public class PromotionDetailInfo {
	
	private PromotionList promoDetails;
	private List<PromotionItemList> promoItemList;
	public PromotionDetailInfo(PromotionList promoDetails, List<PromotionItemList> promoItemList) {
		super();
		this.promoDetails = promoDetails;
		this.promoItemList = promoItemList;
	}
	public PromotionDetailInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PromotionList getPromoDetails() {
		return promoDetails;
	}
	public void setPromoDetails(PromotionList promoDetails) {
		this.promoDetails = promoDetails;
	}
	public List<PromotionItemList> getPromoItemList() {
		return promoItemList;
	}
	public void setPromoItemList(List<PromotionItemList> promoItemList) {
		this.promoItemList = promoItemList;
	}
	
	
	

}
