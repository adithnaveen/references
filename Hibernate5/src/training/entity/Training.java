package training.entity; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="CustomTraining")

public class Training {
	@Id
	@GeneratedValue(generator="increment")
	private int trainingId; 
	private String trainingName; 
	private int durationInDays; 
	
}
