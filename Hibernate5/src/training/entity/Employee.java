package training.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author imssbora
 */
@Entity
@Table(name = "EMPLOYEE")
@Getter
@Setter
@ToString

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID")
	private long id;

	@Column(name = "NAME", nullable = false, unique = true)
	private String name;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "SALARY")
	private double salary;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "EMPLOYEE_ADDRESS", joinColumns = { @JoinColumn(name = "EMP_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ADDR_ID") })
	private List<Address> addresses = new ArrayList<>();

	public Employee() {
	}

	public Employee(String name, String designation, double salary) {
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	// Setter and Getter methods
}