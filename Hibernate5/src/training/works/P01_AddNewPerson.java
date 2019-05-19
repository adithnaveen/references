package training.works;

import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import training.entity.Person;
import training.util.HibernateUtil;

public class P01_AddNewPerson {

	public static void main(String[] args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		Person p1 = new Person();
		p1.setName("Harry");
		p1.setAge(45);
		p1.setHeight(6.3);
		p1.setBirthDate(sdf.parse("10-10-1983"));

		SessionFactory factory = HibernateUtil.getSessionFactory();
		// get a session object (represents a connection to DB, provides CRUD
		// operations)
		// A.K.A Level-1 Cache
		Session session = factory.openSession();

		// perform CRUD operations
		// 1. begin transaction
		Transaction tx = session.beginTransaction();
		try {
			// 2. perform INSERT/UPDATE/DELETE operations
			session.persist(p1);
			// 3. try committing the transactions
			tx.commit();
			System.out.println("Data saved!");
		} catch (Exception e) {
			// 4. in case of an error, rollback all INSERT/UPDATE/DELETE stuffs.
			tx.rollback();
			System.out.println("Could not save data");
		}
		session.close();
		factory.close(); // in practice, should be singleton
	}
}
