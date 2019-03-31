package com.training.reactive.beans;

public class Stock {
	private String companyName; 
	
	
	
	private double stockPrice;
	public Stock(String companyName, double stockPrice) {
		super();
		this.companyName = companyName;
		this.stockPrice = stockPrice;
	}
	
	
	
	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public double getStockPrice() {
		return stockPrice;
	}



	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}



	@Override
	public String toString() {
		return "Stock [companyName=" + companyName + ", stockPrice=" + stockPrice + "]";
	} 
	
}
