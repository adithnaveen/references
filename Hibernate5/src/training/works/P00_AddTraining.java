package training.works;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import training.entity.Training;
import training.util.HibernateUtil;

public class P00_AddTraining {
	public static void main(String[] args) {
		Training tt = new Training(); 
		tt.setTrainingName("Hibernate Training");
		tt.setDurationInDays(3);
		
		SessionFactory  factory = HibernateUtil.getSessionFactory(); 
		
		Session session = factory.openSession(); 
		
		Transaction tx = session.beginTransaction(); 
		
		try {
			session.persist(tt);
			tx.commit();
			System.out.println("Data Saved... ");
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
			System.out.println("Data Not Saved");
		}
		
		session.close(); 
		factory.close(); 
	}
}
