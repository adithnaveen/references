package training.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CellPhone extends Product {
	private String type; // ordinary or smart 
	private String os;   // iOS, Android, Windows
	private String connectivity;  // GSM, CDMA
	
	public CellPhone(int pId, String pName, 
			String pDesc, double pPrice, String type, 
			String os, String connectivity) {

		super(pId, pName, pDesc, pPrice);
		
		this.type = type;
		this.os = os;
		this.connectivity = connectivity;
	}
	
	
}
