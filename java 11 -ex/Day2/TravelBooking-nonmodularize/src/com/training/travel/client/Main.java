package com.training.travel.client;

import com.training.travel.book.BookingBusinessLogic;

public class Main {
	public static void main(String[] args) {
		BookingBusinessLogic bbl = new BookingBusinessLogic(); 
		
		System.out.println("*************** List of travel itenaries ***************");
		bbl.getPlaces().forEach(System.out :: println);
		
		System.out.println("************************************************* ");
		System.out.println(bbl.bookTravelItenary()); 
		System.out.println("************************************************* ");		
		
	}
}
