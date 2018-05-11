package com.library.binding;

import java.util.Date;

public class CardInfo {

	String cardNo ;
	Date expiryDate ;
	
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public void print() {
		System.out.println(cardNo);
		System.out.println(expiryDate);
	}
	
	
}
