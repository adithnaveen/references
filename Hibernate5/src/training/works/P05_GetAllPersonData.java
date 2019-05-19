package training.works;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import training.entity.Person;
import training.util.HibernateUtil;

public class P05_GetAllPersonData {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
//		getWithHQL(session);
		getWithCriteria(session);
	}

	private static void getWithHQL(Session session) {
		List<Person> persons = session.createQuery("from training.entity.Person").list();
		persons.forEach((temp) -> System.out.println(temp));
	}

	private static void getWithCriteria(Session session) {
		CriteriaBuilder builder = session.getCriteriaBuilder();

		javax.persistence.criteria.CriteriaQuery<Person> cr = builder.createQuery(Person.class);
		cr.from(Person.class);
		
		session.createQuery(cr).getResultList().forEach(System.out ::println);

		
	}
}
