package com.storeOperation.productinfomation.Entity;

public class ModePaymentDto {
	
	private float cash;
	private float cheque;
	private float creditcard;
	private float giftcard;
	private float debitcard;
	public ModePaymentDto(float cash, float cheque, float creditcard, float giftcard, float debitcard) {
		super();
		this.cash = cash;
		this.cheque = cheque;
		this.creditcard = creditcard;
		this.giftcard = giftcard;
		this.debitcard = debitcard;
	}
	public float getCash() {
		return cash;
	}
	public void setCash(float cash) {
		this.cash = cash;
	}
	public float getCheque() {
		return cheque;
	}
	public void setCheque(float cheque) {
		this.cheque = cheque;
	}
	public float getCreditcard() {
		return creditcard;
	}
	public void setCreditcard(float creditcard) {
		this.creditcard = creditcard;
	}
	public float getGiftcard() {
		return giftcard;
	}
	public void setGiftcard(float giftcard) {
		this.giftcard = giftcard;
	}
	public float getDebitcard() {
		return debitcard;
	}
	public void setDebitcard(float debitcard) {
		this.debitcard = debitcard;
	}
	public ModePaymentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
