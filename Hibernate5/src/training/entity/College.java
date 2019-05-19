package training.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class College {
	
	@Id
	@GeneratedValue
	private int collegeId; 
	private String collegeName;
	
	@Getter
	@Setter
	@Embedded
	private CollegeDetails collegeDetails; 
	
	
}
