package com.training.travel.book.commission;

// this class is not to be shared, and we want to hide it from the caller, 
// this class shall contain sensitive information such the commission paid 
// for booking site 
public class VendorCommission {
	public static String payCommission(String from, String to) {
		// any complicated code can go here 
		return "Commssion is paid for Booking \nFrom : " + from +", To : " + to;  
	}
}
