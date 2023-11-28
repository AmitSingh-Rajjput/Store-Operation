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
public class PromotionItemList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "prod_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "promotion_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private PromotionList promotionList;
	
	private Float promoPrice;

	public PromotionItemList(Long id, Product product, PromotionList promotionList, Float promoPrice) {
		super();
		this.id = id;
		this.product = product;
		this.promotionList = promotionList;
		this.promoPrice = promoPrice;
	}

	public Float getPromoPrice() {
		return promoPrice;
	}

	public void setPromoPrice(Float promoPrice) {
		this.promoPrice = promoPrice;
	}

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

	public PromotionList getPromotionList() {
		return promotionList;
	}

	public void setPromotionList(PromotionList promotionList) {
		this.promotionList = promotionList;
	}

	public PromotionItemList(Long id, Product product, PromotionList promotionList) {
		super();
		this.id = id;
		this.product = product;
		this.promotionList = promotionList;
	}

	public PromotionItemList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PromotionItemList(Product product, PromotionList promotionList, Float promoPrice) {
		super();
		this.product = product;
		this.promotionList = promotionList;
		this.promoPrice = promoPrice;
	}
	
	

}
