package com.training.reactive.app;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;

import com.training.reactive.beans.Stock;
import com.training.reactive.subscriber.StockExchange;
import com.training.reactive.utility.LoadData;

public class StockApp {
	public static void main(String[] args) {
		
		SubmissionPublisher<Stock>
			publisher = new SubmissionPublisher<>(); 
		
		// invoking the subscriber 
		publisher.subscribe(new 
				StockExchange()); 
		
		List<Stock> stocks = LoadData.getStocks(); 
		
		stocks.stream().forEach(item ->  {
			publisher.submit(item); 
			sleep(500);
			
		});
		
		
		publisher.close(); 
		System.out.println("Exiting ");
	}

	private static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
