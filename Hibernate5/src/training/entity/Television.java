package training.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Television extends Product {
	private int size;   // in inches 
	private String screenType; // LED/CRT/LCD
	private String resolution; // 1024x786, 2048 x 1400 
	
	// this feature is missing in lambok
	public Television(int pId, String pName, String pDesc, double pPrice, int size, String screenType,
			String resolution) {
		super(pId, pName, pDesc, pPrice);
		this.size = size;
		this.screenType = screenType;
		this.resolution = resolution;
	}
	
	
	
}