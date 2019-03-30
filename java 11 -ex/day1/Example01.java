package com.training;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Example01 {

    public static void main(String[] args) {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
            .uri(URI.create("http://probits.in"))
            .build();
            
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(System.out::println)
            .join();
    }
    
    public static void httpInvoke() {
    	var client = HttpClient.newHttpClient(); 
    	
    	var req = HttpRequest.newBuilder().uri(URI.create("http://probits.in")).build(); 


    }

}
