package com.training.TrainingWorks.user;

public class Address {
	private int houseNo; 
	private String street; 
	private String city; 
	private String country;
	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", street=" + street + ", city=" + city + ", country=" + country + "]";
	}
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Address(int houseNo, String street, String city, String country) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.country = country;
	} 
	
	
	
}
