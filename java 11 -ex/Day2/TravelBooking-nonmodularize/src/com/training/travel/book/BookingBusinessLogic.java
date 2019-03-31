package com.training.travel.book;

import java.util.List;

import com.training.travel.book.commission.VendorCommission;
import com.training.travel.model.Places;

/** 
 * 
 * @author Naveen
 * 
 */
public class BookingBusinessLogic {
	
	List<Places> places = List.of(
			new Places("Bengaluru", "Delhi"), 
			new Places("Bengaluru", "Mysuru"),
			new Places("Delhi", "Chennai"),
			new Places("Bombay", "Bengaluru"),
			new Places("Bombay", "Delhi")
	); 
	
	
	private static int randomTravelPlaces() {
		return (int) (Math.random()*5); 
	}
		
	public String bookTravelItenary() {
		int randomNumber = randomTravelPlaces(); 
		Places travel = places.get(randomNumber);
		
		return "Travelling From : " + travel.getSource() +", To : " + travel.getDestination() +"\ncommission charges " + 
			VendorCommission.payCommission(travel.getSource(), travel.getDestination()); 
	}
	
	public String getCompanyName() {
		return "Super Travel Company"; 
	}
	
	public int getNumberOfPlaces() {
		return places.size(); 
	}
	
	public List<Places> getPlaces(){
		return this.places; 
	}
	
}
