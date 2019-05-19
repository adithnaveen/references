package training.works;

import java.util.GregorianCalendar;

import org.hibernate.Session;

import training.entity.Customer;
import training.util.HibernateUtil;

public class P08_OneClassTwoTable {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Customer customer = new Customer(0, "Naveen", 32434, "naveen@probits.in", 
				"dontsay", new GregorianCalendar(1990, 02, 22)); 
		session.save(customer); 
		session.beginTransaction().commit(); 
		
		System.out.println("Saved... ");
		
	}
}
