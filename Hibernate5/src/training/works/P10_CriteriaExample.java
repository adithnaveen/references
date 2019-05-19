package training.works;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import training.entity.Person;
import training.util.HibernateUtil;

public class P10_CriteriaExample {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession(); 

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class); 
		Root<Person> root = query.from(Person.class);
		
//		selectAll(session, query, root);
//		selectOneRecord(session, criteriaBuilder, query, root);

//		selectOneField(session);
		selectMultiFiledWithCondition(session);
	}

	// select * from employee where id = 1; 
	private static void selectOneRecord(Session session, 
			CriteriaBuilder criteriaBuilder, CriteriaQuery<Person> query,
			Root<Person> root) {
		query.select(root).where(criteriaBuilder.equal(root.get("id"), 1)); 
		Query<Person> q = session.createQuery(query); 
		Person person = q.getSingleResult(); 
		
		System.out.println(person);
	}

	// similar to select * from person
	private static void selectAll(Session session, CriteriaQuery<Person> query, Root<Person> root) {
		query.select(root); 
		Query<Person> q = session.createQuery(query); 
		
		List<Person> persons = q.getResultList(); 

		persons.forEach(System.out :: println);
	}
	
	private static void selectOneField(Session session) {
		session.beginTransaction();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		// this is very important if you are taking 1 field from the db 
		// in earlier examples it was person class 
		CriteriaQuery<String> query = builder.createQuery(String.class); 
		Root<Person> root = query.from(Person.class); 
		query.select(root.get("name")); 
		
		Query<String> q = session.createQuery(query); 
		
		List<String> listOfNames  = q.getResultList(); 
		listOfNames.forEach(System.out :: println);
	}
	
	private static void selectMultiFiledWithCondition(Session session) {
		session.beginTransaction(); 
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class); 
		Root<Person> root = query.from(Person.class); 
		
		Predicate greaterThan = builder.greaterThan(root.get("age"), 34);
		
		query.multiselect(root.get("name"), root.get("age")).
			where(greaterThan).getOrderList(); 
		
//		query.orderBy(builder.asc(root.get("age"))); 
		query.orderBy(builder.desc(root.get("age")));
		
		Query<Object[]> q = session.createQuery(query); 
		List<Object[]> list = q.getResultList(); 
		
		for(Object[] temp : list) {
			System.out.println("Name : " + temp[0] +", Age : " + temp[1]);
		}
	}
}
