package com.storeOperation.productinfomation.Entity;

import java.util.List;

public class PromotionAddDto {
	
	private String productItemNo;
	
	private Float productPromoPrice;
	
	private String promotionId;

	public PromotionAddDto(String productItemNo, Float productPromoPrice, String promotionId) {
		super();
		this.productItemNo = productItemNo;
		this.productPromoPrice = productPromoPrice;
		this.promotionId = promotionId;
	}

	public String getProductItemNo() {
		return productItemNo;
	}

	public void setProductItemNo(String productItemNo) {
		this.productItemNo = productItemNo;
	}

	public Float getProductPromoPrice() {
		return productPromoPrice;
	}

	public void setProductPromoPrice(Float productPromoPrice) {
		this.productPromoPrice = productPromoPrice;
	}

	public String getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}

	public PromotionAddDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
