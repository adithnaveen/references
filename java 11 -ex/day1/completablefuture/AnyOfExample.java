package com.training.completablefuture;

import java.util.concurrent.ExecutionException;

import java.util.concurrent.CompletableFuture;
import static java.util.concurrent.CompletableFuture.supplyAsync;

public class AnyOfExample {
	private int x;
	static String job1 = "Job-1";
	static String job2 = "Job-2";
	static String job3 = "Job-3";

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		System.out.println("In Main" + Thread.currentThread());

		anyWork();
//		sampleWork(); 
		CompletableFuture<String> cf = supplyAsync(() -> {
			return "Hello";
		});
		cf.defaultExecutor().execute(() -> {
			System.out.println("in execute");
		});

		System.out.println(cf.copy().get());
		System.out.println(cf.toCompletableFuture().get());
	}

	private static void sampleWork() {
		CompletableFuture<String> completableFuture = null;
		try {
			completableFuture = supplyAsync(() -> {
				int x = 10;
				if (x == 10) {
					throw new RuntimeException("I'm RunTimeException in CF ");
				}
				return "Hello World sample work";
			});
			System.out.println(completableFuture.join());
			completableFuture.completeExceptionally(new RuntimeException("Wow!! I'm RunTimeException"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void anyWork() throws InterruptedException, ExecutionException {
		CompletableFuture<String> req1 = supplyAsync(() -> {
			sleep(1000);
			System.out.println(job1 + " in " + Thread.currentThread());
			return job1 + " Completed";
		});

		CompletableFuture<String> req2 = supplyAsync(() -> {
			sleep(1000);
			System.out.println(job2 + " in " + Thread.currentThread());
			return job2 + " Completed";
		});

		CompletableFuture<String> req3 = supplyAsync(() -> {
			sleep(1000);
			System.out.println(job3 + " in " + Thread.currentThread());
			return job3 + " Completed";
		});

		CompletableFuture<Object> anyCompletableFuture = CompletableFuture.anyOf(req1, req2, req3);
		System.out.println((String) anyCompletableFuture.get());
	}

	private static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}