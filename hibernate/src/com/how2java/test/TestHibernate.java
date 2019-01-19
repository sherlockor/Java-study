package com.how2java.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;
import com.how2java.pojo.User;

public class TestHibernate {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();
		s.beginTransaction();
		
//		for(int index = 0; index < 10; index++) {
//			Product p = new Product();
//			p.setName("iphone" + index);
//			p.setPrice(index);
//			s.save(p);
//		}
		
		//Product p = (Product)s.get(Product.class, 5);
		//System.out.println("id=6的产品名称是：" + p.getName());
		//p.setName(p.getName() + "-modified");
		//s.update(p);
		//s.delete(p);
		
		//hql语句查询
//		String name = "iphone";
//		Query q = s.createQuery("from Product p where p.name like ?");
//		q.setString(0, "%" + name + "%");
//		List<Product> psList = q.list();
//		for(Product product : psList) {
//			System.out.println(product.getName() + "   " + product.getPrice());
//		}
		
		//criteria查询
//		String name = "iphone";
//		Criteria criteria = s.createCriteria(Product.class);
//		criteria.add(Restrictions.like("name", "%" + name + "%"));
//		List<Product> psList = criteria.list();
//		for(Product product : psList) {
//			System.out.println(product.getName() + "   " + product.getPrice());
//		}
		
		//sql
//		String name = "iphone";
//		String sql = "select * from product_ p where p.name like '%" + name + "%'";
//		Query query = s.createSQLQuery(sql);
//		List<Object[]> list = query.list();
//		for(Object[] osObjects : list) {
//			for(Object filedObject : osObjects ) {
//				System.out.print(filedObject + "\t");
//			}
//			System.out.println();
//		}
		
		//多个product可以包含同一个category
//		Category category = new Category();
//		category.setName("c1");
//		s.save(category);
//		Product product = (Product)s.get(Product.class, 8);
//		product.setCategory(category);
//		Product product2 = (Product)s.get(Product.class, 7);
//		product2.setCategory(category);
//		s.update(product);
		
		//通过category获取包含之的product
//		Category category = (Category)s.get(Category.class, 2);
//		Set<Product> pSet = category.getProducts();
//		for(Product product : pSet) {
//			System.out.println(product.getName());
//		}
		//增加3个用户
        Set<User> users = new HashSet();
        for (int i = 0; i < 3; i++) {
            User u =new User();
            u.setName("user"+i);
            users.add(u);
            s.save(u);
        }
          
        //产品3被用户1,2,3购买
        Product p1 = (Product) s.get(Product.class, 3);
        p1.setUsers(users);
        s.save(p1);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}

}
