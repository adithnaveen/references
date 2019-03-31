package com.training;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse.PushPromiseHandler;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.stream.Collectors;

// http CRUD Operations 
public class HttpClientExample {

	private static String getTMS="https://trainingmanagementapp.herokuapp.com/api/courses/5c9f468e13f3a52110b3793e"; 
	
	
	public static void main(String[] args) throws Exception {
//		httpGetRequest();
        	httpPostRequest();
//			asynchronousGetRequest();
		// dont try this 
//			asynchronousMultipleRequests();
		// dont try 
//        	pushRequest();
	}

	public static void httpGetRequest() throws URISyntaxException, IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().version(HttpClient.Version.HTTP_1_1)
				.uri(URI.create("https://trainingmanagementapp.herokuapp.com/api/courses/5c9f468e13f3a52110b3793e"))
//            Sends "Accept-Encoding: gzip,deflate" request header and 
//            decompresses based on Content-Encoding (configurable) Redirects 
//            are no longer followed by default.
				.headers("Accept-Enconding", "gzip, deflate").build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

		String responseBody = response.body();
		int responseStatusCode = response.statusCode();

		System.out.println("httpGetRequest: " + responseBody);
		System.out.println("httpGetRequest status code: " + responseStatusCode);
	}

	public static void httpPostRequest() throws URISyntaxException, IOException, InterruptedException {
		HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
		HttpRequest request = HttpRequest.newBuilder(new URI("http://jsonplaceholder.typicode.com/posts"))
				.version(HttpClient.Version.HTTP_2)
//            .POST(BodyPublishers.ofString("Sample Post Request - Naveen "))
				// this will give always 101 as there are already 100 records 
				.POST(BodyPublishers.ofString("{\r\n" + "\"userId\": 10,\r\n" + "\"id\": 1,\r\n"
						+ "\"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\r\n"
						+ "\"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\r\n"
						+ "}"))
				.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String responseBody = response.body();
		System.out.println("httpPostRequest : " + responseBody);
	}

	public static void asynchronousGetRequest() throws URISyntaxException {
		try {
			HttpClient client = HttpClient.newHttpClient();
			URI httpURI = new URI("http://jsonplaceholder.typicode.com/posts/1");
			HttpRequest request = HttpRequest.newBuilder(httpURI).version(HttpClient.Version.HTTP_2).build();

			CompletableFuture<Void> futureResponse = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
					.thenAccept(resp -> {

						System.out.println("Got pushed response " + resp.uri());
						System.out.println("Response statuscode: " + resp.statusCode());
						System.out.println("Response body: " + resp.body());
					});
			System.out.println("futureResponse" + futureResponse);
			System.out.println("isDone status " +futureResponse.isDone());

			// this method will not leave the scope till the response is got
			futureResponse.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

	public static void asynchronousMultipleRequests() throws URISyntaxException {
		HttpClient client = HttpClient.newHttpClient();
		List<URI> uris = Arrays.asList(new URI("http://jsonplaceholder.typicode.com/posts/1"),
				new URI("http://jsonplaceholder.typicode.com/posts/2"));

		List<HttpRequest> requests = uris.stream().map(HttpRequest::newBuilder).map(reqBuilder -> reqBuilder.build())
				.collect(Collectors.toList());

		System.out.println("Got pushed response1 " + requests);

		requests.forEach(System.out::println);

		CompletableFuture.allOf(requests.stream().map(request -> client.sendAsync(request, BodyHandlers.ofString()))
				.toArray(CompletableFuture<?>[]::new)).thenAccept(System.out::println).join();

		System.out.println("Some other business logic");
	}

	public static void pushRequest() throws URISyntaxException, InterruptedException {
		System.out.println("Running HTTP/2 Server Push example...");

		HttpClient httpClient = HttpClient.newBuilder().version(Version.HTTP_2).build();

		HttpRequest pageRequest = HttpRequest.newBuilder()
				// http://jsonplaceholder.typicode.com/posts/1
				.uri(URI.create("https://http2.golang.org/serverpush")).build();

		// Interface HttpResponse.PushPromiseHandler<T>
		// void applyPushPromise?(HttpRequest initiatingRequest, HttpRequest
		// pushPromiseRequest,
		// Function<HttpResponse.BodyHandler<T>,?CompletableFuture<HttpResponse<T>>>
		// acceptor)
		httpClient.sendAsync(pageRequest, BodyHandlers.ofString(), pushPromiseHandler()).
			thenAccept(pageResponse -> {
			System.out.println("Page response status code: " + pageResponse.statusCode());
			System.out.println("Page response headers: " + pageResponse.headers());
			String responseBody = pageResponse.body();
			System.out.println(responseBody);
		}).join();

		Thread.sleep(1000); // waiting for full response
	}

	private static PushPromiseHandler<String> pushPromiseHandler() {
		return (HttpRequest initiatingRequest, 
				HttpRequest pushPromiseRequest,
				Function<HttpResponse.BodyHandler<String>, 
				CompletableFuture<HttpResponse<String>>> acceptor) -> {
					
			acceptor.apply(BodyHandlers.ofString()).thenAccept(resp -> {
				System.out.println(" Pushed response: " + resp.uri() + ", headers: " + resp.headers());
			});
			System.out.println("Promise request: " + pushPromiseRequest.uri());
			System.out.println("Promise request: " + pushPromiseRequest.headers());
		};
	}

}