package training.works;

import org.hibernate.Session;

import training.entity.CellPhone;
import training.entity.Product;
import training.entity.Television;
import training.util.HibernateUtil;


// program to show working of inheritance with television, cellphone and super class 
// as product 

public class P06_Inheritence {
	public static void main(String[] args) {
		Product products[] = {
//				new CellPhone("Smart", "Android", "CDMA", 101, "Samsung", "samsung s7 series", 4444), 
//				new CellPhone("Smart", "iOS", "GSM", 102, "Apple", "S6", 6666),
				new Television(111, "Samsung", "monitor", 334.3, 44, "LED", "123x332"),
				new Television(112, "Samsung", "monitor", 334.3, 44, "LED", "123x332"), 
				new Television(113, "Samsung", "monitor", 334.3, 44, "LED", "123x332"), 
				new CellPhone(114, "Apple", "Apple Mobile", 455, "Smart", "iOS", "CDMA")
		};
		
		
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		
		for(Product temp : products){
			session.persist(temp);
		}
		session.beginTransaction().commit();
		
		
		System.out.println("Saved... ");
	}
}