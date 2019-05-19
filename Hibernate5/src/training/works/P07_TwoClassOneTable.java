package training.works;

import org.hibernate.Session;

import training.entity.College;
import training.entity.CollegeDetails;
import training.util.HibernateUtil;

// program to show working of two tables College, CollegeDetails to store in the 
// the same table 

public class P07_TwoClassOneTable {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		
		session.beginTransaction(); 
		
		CollegeDetails collegeDetail = new CollegeDetails(44, "Bengaluru", "+91 99004433"); 
		College college = new College(101, "SJRC", collegeDetail); 
		
		session.save(college); 
		
		
		session.getTransaction().commit(); 
		System.out.println("Saved... ");
	}
}
