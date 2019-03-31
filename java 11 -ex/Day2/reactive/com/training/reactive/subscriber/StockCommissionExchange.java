package com.training.reactive.subscriber;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import com.training.reactive.beans.Commission;

public class StockCommissionExchange implements Subscriber<Commission>{
	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		// getting 1 item from publisher 
		subscription.request(1);
	}

	@Override
	public void onNext(Commission item) {
		System.out.println("onNext [Commission] : " + item);
		this.subscription.request(1);	}

	@Override
	public void onError(Throwable throwable) {
		System.out.println("Exception occured for Stock Commission");
		throwable.printStackTrace(); 
	}

	@Override
	public void onComplete() {
		System.out.println("All stocks processed");
	} 
}
