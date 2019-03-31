package com.training.reactive.processor;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

import com.training.reactive.beans.Commission;
import com.training.reactive.beans.Stock;

public class ChainingStockCommission extends SubmissionPublisher<Commission>
	implements Processor<Stock, Commission>{

	private Subscription subscription; 
	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription; 
		subscription.request(1);
	}

	@Override
	public void onNext(Stock item) {
		this.submit((Commission) item); 
		subscription.request(1); 
	}

	@Override
	public void onError(Throwable throwable) {
		System.out.println("Exception in ChainingStockCommitssion");
		throwable.printStackTrace(); 
	}

	@Override
	public void onComplete() {
		System.out.println("Chaining Stock Commission completed..");
	}
	
	

}
