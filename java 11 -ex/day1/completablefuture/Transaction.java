package com.training.completablefuture;

public class Transaction{
	public int getBalance() {
		System.out.println("In Transaction : Thread : "+ Thread.currentThread());
		
		for(int i=0; i<5000; i++) {System.out.print("");}
		return (int) (Math.random()*10000);
	}
}