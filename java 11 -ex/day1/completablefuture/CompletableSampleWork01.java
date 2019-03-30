package com.training.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Naveen
 * @see This program shows working of the thread usage of CompletableFuture
 */

public class CompletableSampleWork01 {
	public static void main(String[] args) {
		System.out.println("In Main : Thread : " + Thread.currentThread());
//		singleThreadedModel();
		System.out.println("----------------------------------------------");
		completableMethod01();
		System.out.println("-----------------------------------------------");
//		completableMethod02(); 

	}

	// with sleep, note that display is shown in main thread
	private static void completableMethod02() {
		Transaction transaction = new Transaction();
		CompletableFuture<Integer> completableFuture = completableFuture(transaction);

		sleep(1000);
		completableFuture.thenAccept(balance -> display(balance));
		sleep(1000);
	}

	// without sleep
	private static void completableMethod01() {
		Transaction transaction = new Transaction();
		// if the job is completed before the control
		// or timeout Since JDK 9
		completableFuture(transaction).thenAccept(balance -> display(balance)).orTimeout(1, TimeUnit.SECONDS);
	}

	// new thread is created, now this is non blocking thread
	public static CompletableFuture<Integer> completableFuture(Transaction transaction) {
		System.out.println("In completableFuture : " + Thread.currentThread());
		return CompletableFuture.supplyAsync(() -> transaction.getBalance());
	}

	private static void singleThreadedModel() {
		Transaction transaction = new Transaction();
		System.out.println("In single thread model : Thread : " + Thread.currentThread());
		display(transaction.getBalance());
	}

	private static void display(int balance) {
		System.out.println("Balance : " + balance);
		System.out.println("In display : Thread : " + Thread.currentThread());
	}

	private static void sleep(int i) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}