package com.training.TrainingWorks.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Document
@ApiModel(description = "All details about the user")
public class User {
	private Integer id;

	@Size(min = 3, max = 20, message = "Name Should Be Min 3 Chars. ")
	@ApiModelProperty(notes = "Name Should have altest 3 and max of 30 chars")
	private String name;

	@Past
	@ApiModelProperty(notes = "Birth date should be in past ")
	private Date birthDate;

	private String email;
	private double income; 
	
	private Address address; 
	
	
	
	
	////////////////////////// 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}




	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", email=" + email + ", income="
				+ income + ", address=" + address + "]";
	}

	public User() {
	}

	public User(Integer id, String name, Date birthDate, String email, 
			double income, Address address) {
		
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
		this.income = income;
		this.address = address; 
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
