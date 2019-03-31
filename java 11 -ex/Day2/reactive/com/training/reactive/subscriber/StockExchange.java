package com.training.reactive.subscriber;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import com.training.reactive.beans.Stock;

public class StockExchange implements Subscriber<Stock> {
	private Subscription subscription;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription; 
		subscription.request(1);
	}

	@Override
	public void onNext(Stock item) {
		System.out.println("onNext [Stock] : " + item);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		new Exception("Exception Occured in Stock Exchange", throwable); 
	}

	@Override
	public void onComplete() {
		System.out.println("Finished Processing Given Stock");
	}

		
}
