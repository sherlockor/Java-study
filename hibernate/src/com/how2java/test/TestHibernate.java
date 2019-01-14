package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;
import com.how2java.pojo.Category;

public class TestHibernate {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();
		s.beginTransaction();

		Product p = new Product();
		p.setName("iphone8");
		p.setPrice(8000);
		s.save(p);
		
		//Category category = new Category();
		//category.setName("·ÖÀà1");
		//s.save(category);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}

}
