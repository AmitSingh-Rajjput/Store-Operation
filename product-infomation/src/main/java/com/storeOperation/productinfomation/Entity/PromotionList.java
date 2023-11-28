package com.storeOperation.productinfomation.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="promotionlist")
public class PromotionList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String promotionId;
	
	private String promotionName;
	
	private String promotionDescription;
	
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
	private String promotionFrom;
	
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
	private String promotionTill;

	public PromotionList(Long id, String promotionId, String promotionName, String promotionDescription,
			String promotionFrom, String promotionTill) {
		super();
		this.id = id;
		this.promotionId = promotionId;
		this.promotionName = promotionName;
		this.promotionDescription = promotionDescription;
		this.promotionFrom = promotionFrom;
		this.promotionTill = promotionTill;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public String getPromotionDescription() {
		return promotionDescription;
	}

	public void setPromotionDescription(String promotionDescription) {
		this.promotionDescription = promotionDescription;
	}

	public String getPromotionFrom() {
		return promotionFrom;
	}

	public void setPromotionFrom(String promotionFrom) {
		this.promotionFrom = promotionFrom;
	}

	public String getPromotionTill() {
		return promotionTill;
	}

	public void setPromotionTill(String promotionTill) {
		this.promotionTill = promotionTill;
	}

	public PromotionList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
