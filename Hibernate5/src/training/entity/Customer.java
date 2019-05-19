package training.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Table(name="CustomerMaster")
@SecondaryTable(name="CustomerDetail")
public class Customer {
	
	@Id
	@GeneratedValue
	private int customrId; 
	private String customerName; 
	
	@Column(table="customerDetail")
	private double customerIncome;
	
	@Column(table="customerDetail")
	private String customerEmail; 
	
	@Transient
	private String password; 
	@Temporal(TemporalType.DATE)
	private Calendar calendar; 
	
}
