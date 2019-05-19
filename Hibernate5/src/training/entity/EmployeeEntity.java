package training.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Employee", uniqueConstraints= {@UniqueConstraint(columnNames="ID"), @UniqueConstraint(columnNames="EMAIL")})
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	private int employeeId; 
	
	@Column(name="EMAIL", unique=true, nullable=false, length=100)
	private String email; 
	@Column(name="FIRST_NAME", unique=true, nullable=false, length=100)
	private String firstName; 
	@Column(name="LAST_NAME", unique=true, nullable=false, length=150)
	private String lastName; 

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="EMPLOYEE_ID")
	private Set<AccountEntity> accounts; 
}
