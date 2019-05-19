package training.entity;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Embeddable
public class CollegeDetails {
	private int colleggeStrength; 
	private String collegeLocation; 
	private String collegeContact; 
	
	
}
