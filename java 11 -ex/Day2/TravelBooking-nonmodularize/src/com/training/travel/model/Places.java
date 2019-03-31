package com.training.travel.model;

public class Places {
	private String source; 
	private String destination;
	
	public Places() {}
	
	public Places(String source, String destination) {
		super();
		this.source = source;
		this.destination = destination;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	} 

	@Override
	public String toString() {
		return "Places [source=" + source + ", destination=" + destination + "]";
	}
	
}
