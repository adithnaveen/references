package training.works;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import training.entity.AccountEntity;
import training.entity.EmployeeEntity;
import training.util.HibernateUtil;

public class P09_OneTWoManyForeignKeyAssociation {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession(); 
		
		session.beginTransaction(); 

		EmployeeEntity emp1 = new EmployeeEntity(); 
		emp1.setFirstName("Naveen");
		emp1.setLastName("Kumar");
		emp1.setEmail("naveen@probits.in"); 
		
		
		EmployeeEntity emp2  = new EmployeeEntity(); 
		emp2.setFirstName("Harry");
		emp2.setLastName("Potter");
		emp2.setEmail("harry@potter.com"); 
		
		
		AccountEntity account1 = new AccountEntity(); 
		account1.setAccountNumber("1234");
		
		AccountEntity account2 = new AccountEntity(); 
		account2.setAccountNumber("4433");
		
		AccountEntity account3 = new AccountEntity(); 
		account3.setAccountNumber("3211");
		
		
		Set<AccountEntity> accountsOfEmp1 = new HashSet<>(); 
		accountsOfEmp1.add(account1);
		accountsOfEmp1.add(account2);
		
		Set<AccountEntity> accountsOfEmp2 = new HashSet<>(); 
		accountsOfEmp2.add(account3);
		
		emp1.setAccounts(accountsOfEmp1);
		emp2.setAccounts(accountsOfEmp2);
		
		
		session.save(emp1); 
		session.save(emp2); 
		
		session.getTransaction().commit(); 
		
		System.out.println("Saved... ");
		

	}
}


