package training.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity


//Approach #1
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "PRODUCT_TYPE", discriminatorType =DiscriminatorType.STRING)

//Approach #2
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

//Approach #3 (normalized)
@Inheritance(strategy=InheritanceType.JOINED)


public class Product {
	@Id
	private int pId;
	private String pName;
	private String pDesc;
	private double pPrice;
		
}