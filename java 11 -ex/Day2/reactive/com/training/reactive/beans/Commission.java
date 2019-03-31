package com.training.reactive.beans;

public class Commission extends Stock {

	private double commission;

	public Commission(String companyName, double stockPrice, double commission) {
		super(companyName, stockPrice);
		this.commission = commission;
	}

	public Commission(Stock stock, double commission) {
		super(stock.getCompanyName(), stock.getStockPrice());
		this.commission = commission;
	}
	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	@Override
	public String toString() {
		return super.toString() + ", Commission [commission=" + commission + "]" ;
	}

}
