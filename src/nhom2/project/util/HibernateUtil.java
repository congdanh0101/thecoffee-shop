package nhom2.project.util;

import nhom2.project.model.Product;
import nhom2.project.model.Topping;
import nhom2.project.model.Bill;
import nhom2.project.model.BillDetail;
import nhom2.project.model.Category;
import nhom2.project.model.Customer;
import nhom2.project.model.Size;
import nhom2.project.model.Status;

import java.util.Properties;

import javax.print.attribute.standard.Sides;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

//	public static SessionFactory getSessionFactory() {
//		if (sessionFactory == null) {
//			try {
//				Configuration configuration = new Configuration();
//
//				// Hibernate settings equivalent to hibernate.cfg.xml's properties
//				Properties settings = new Properties();
//
//				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
//				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/coffeeshop?useSSL=false");
//				settings.put(Environment.USER, "root");
//				settings.put(Environment.PASS, "congdanh010101");
//				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//				settings.put(Environment.SHOW_SQL, "true");
//				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//				settings.put(Environment.HBM2DDL_AUTO, "update");
//				
//				configuration.setProperties(settings);
//				configuration.addAnnotatedClass(Product.class);
//				configuration.addAnnotatedClass(Category.class);
//				configuration.addAnnotatedClass(Topping.class);
//				configuration.addAnnotatedClass(Size.class);
//				configuration.addAnnotatedClass(Status.class);
//				configuration.addAnnotatedClass(Customer.class);
//				configuration.addAnnotatedClass(Bill.class);
//				configuration.addAnnotatedClass(BillDetail.class);
//
//				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//						.applySettings(configuration.getProperties()).build();
//				System.out.println("Hibernate Java Config serviceRegistry created");
//				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//				System.out.println(sessionFactory);
//				return sessionFactory;
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println(sessionFactory);
//		return sessionFactory;
//	}
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();

				settings.put(Environment.DRIVER, "org.postgresql.Driver");
				settings.put(Environment.URL, "jdbc:postgresql://ec2-52-2-93-12.compute-1.amazonaws.com:5432/d5na3q7odm12j2?useUnicode=yes&amp;characterEncoding=utf8");
				settings.put(Environment.USER, "aqfezsvojlmdaj");
				settings.put(Environment.PASS, "a5a9f0722e3e7bf2775e7cfbecd953c32c3215f9d187ed8ee2edb64702a5fa71");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Product.class);
				configuration.addAnnotatedClass(Category.class);
				configuration.addAnnotatedClass(Topping.class);
				configuration.addAnnotatedClass(Size.class);
				configuration.addAnnotatedClass(Customer.class);
				configuration.addAnnotatedClass(Status.class);
				configuration.addAnnotatedClass(Bill.class);
				configuration.addAnnotatedClass(BillDetail.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				System.out.println(sessionFactory);
				return sessionFactory;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(sessionFactory);
		return sessionFactory;
	}

}