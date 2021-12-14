package nhom2.project.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import nhom2.project.model.Customer;
import nhom2.project.util.HibernateUtil;

public class CustomerDAO {
	public void saveCustomer(Customer customer) {
		Transaction trans = null;
		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			trans = ss.beginTransaction();
			ss.save(customer);
			trans.commit();
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public void deleteCustomer(int id) {
		Transaction trans = null;
		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			trans = ss.beginTransaction();
			Customer customer = ss.get(Customer.class, id);
			if (customer != null) {
//				String hql = "DELETE FROM Customer WHERE id = :id";
//				Query query = ss.createQuery(hql);
//				query.setParameter("id", id);
//				query.executeUpdate();

				ss.createQuery("DELETE FROM Customer WHERE id = :id").setParameter("id", id).executeUpdate();
			}
			trans.commit();
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomer() {
		try {
			return HibernateUtil.getSessionFactory().openSession().createQuery("FROM Customer").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	public Customer getCustomer(int id) {
		Transaction trans = null;
		Customer customer = null;
		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			trans = ss.beginTransaction();
			customer = ss.get(Customer.class, id);
			trans.commit();
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}
		return customer;
	}

	public Customer getCustomerByEmail(String email) {
//		EntityManager ss = HibernateUtil.getSessionFactory().createEntityManager();
//		String hql = "SELECT u FROM Customer u WHERE u.email = :email";
//		TypedQuery<Customer> q = ss.createQuery(hql,Customer.class);
//		q.setParameter("email", email);
//		try {
//			return q.getSingleResult();
//		}catch (NoResultException e) {
//			return null;
//			// TODO: handle exception
//		}finally {
//			ss.close();
//		}

		Customer customer = null;
		Transaction trans = null;

		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			trans = ss.beginTransaction();
			String hql = "FROM Customer C WHERE C.email = :email";
			Query query = ss.createQuery(hql);
			query.setParameter("email", email);
			List result = query.getResultList();
			if (result != null && !result.isEmpty()) {
				customer = (Customer) result.get(0);
				System.out.println(customer);
			}
			trans.commit();
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}

		return customer;
	}

	public boolean checkCustomerExist(String email) {
		Customer customer = getCustomerByEmail(email);
		return customer != null;
	}

	public void updateCustomer(Customer customer) {
		Transaction trans = null;
		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			trans = ss.beginTransaction();
			String hql = "UPDATE Customer SET name = :name, address = :address, phone = :phone, city = :city, district = :district, ward = :ward WHERE id = :id";
			Query query = ss.createQuery(hql);
			query.setParameter("name", customer.getName()).setParameter("address", customer.getAddress())
					.setParameter("phone", customer.getPhone()).setParameter("city", customer.getCity())
					.setParameter("district", customer.getDistrict()).setParameter("ward", customer.getWard()).setParameter("id", customer.getId());
			query.executeUpdate();
			trans.commit();
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
