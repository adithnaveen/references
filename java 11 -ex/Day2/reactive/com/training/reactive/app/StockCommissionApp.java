package com.training.reactive.app;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

import com.training.reactive.beans.Commission;
import com.training.reactive.beans.Stock;
import com.training.reactive.processor.ChainingStockCommission;
import com.training.reactive.subscriber.StockCommissionExchange;
import com.training.reactive.utility.LoadData;

/**
 * 
 * @author Naveen
 * @see This example shows working with chaining of publisher, processor and subscriber 
 * 		The commission is given for the stock, for the same when stock is purchased or 
 * 		sold, there will be a small amount added, and shown in this example 
 * 
 */
public class StockCommissionApp {
	public static void main(String[] args) {
		// create a publisher
		SubmissionPublisher<Commission> publisher = new SubmissionPublisher<>();

		// subscriber 
		StockCommissionExchange stockCommssionExchange = new StockCommissionExchange();

		// 
		ChainingStockCommission chainingStockCommission = new ChainingStockCommission();

		// publisher to processor
		publisher.subscribe(chainingStockCommission);

		// processor to subscriber
		chainingStockCommission.subscribe(stockCommssionExchange);

		List<Commission> commissions = LoadData.getCommissionAndStock();

		commissions.stream().forEach(temp -> {
			publisher.submit(temp);
			sleep(400);
		});

		publisher.close();
		chainingStockCommission.close();
		System.out.println("exiting main.... ");
	}

	private static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
