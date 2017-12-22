package com.bridgelabz.User.DAO;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.User.model.User;

@Repository
public class UserDaoImplemention implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	public int registration(User user) {
		
		Session session = sessionFactory.getCurrentSession();
		Query<?> query = session.createQuery("from User where email =:email or mobileNumber = :phone");
		query.setParameter("email", user.getEmail());
		query.setParameter("phone", user.getMobileNumber());
		List<?> list = query.list();
		if (list != null) {
			session.save(user);
			
			return 1;
			
		} else {
			
			return 0;
		}
	}

	public User login(User user) {
		Session session = sessionFactory.getCurrentSession();

		Query<?> query = session
				.createQuery("from User where email =:email and password =:password");
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		User name =  (User) query.uniqueResult();

		if (name != null) {
			return name;
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public User getUserByEmail(String email) {
		
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from User where email =:email");
		query.setParameter("email", email);
		User result =  (User) query.uniqueResult();
		if (result != null) {
			System.out.println("UserObJect "+result);
			return result;
		} 
		System.out.println("UserObJect "+result);

		return null;
	}

	public User getUserById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		return user;
	}

	public boolean updateActivation(int id) {
		System.out.println("id:" + id);
		System.out.println("id found");
		Session session = sessionFactory.getCurrentSession();

		Query<?> query = session.createQuery("update User set activated =:activated where id=:id ");
		query.setParameter("id", id);
		query.setParameter("activated", true);
		int i = query.executeUpdate();

		if (i > 0)
			return true;
		else
			return false;
	}
	@Override
	public void updateUser(User oldUser) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(oldUser);
		session.saveOrUpdate(oldUser);
		System.out.println(oldUser);
	}
}
