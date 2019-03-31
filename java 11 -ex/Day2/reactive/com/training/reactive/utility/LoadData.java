package com.training.reactive.utility;

import java.util.ArrayList;
import java.util.List;

import com.training.reactive.beans.Commission;
import com.training.reactive.beans.Stock;

public class LoadData {
	// Simulating the data would be taken from external resource 
	
	public static List<Stock> getStocks(){
		return List.of(
				new Stock("Amazon", 456), 
				new Stock("Google", 443), 
				new Stock("Yahoo", 345), 
				new Stock("Disney", 223), 
				new Stock("Next", 123)
				); 
		
	}
	
	
	public static List<Commission> getCommissionAndStock(){

		List<Commission> commission = new ArrayList<>(); 
		getStocks().forEach((stock) -> {
			commission.add(new Commission(stock, stock.getStockPrice()*0.03)); 
		}); 
		return commission; 
	}
}	
