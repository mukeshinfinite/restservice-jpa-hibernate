package com.mukesh.restapi.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mukesh.restapi.dto.User;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getUsers() {
		
		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createQuery("from User");
//		List<User> users = query.list();
		
		Criteria cr = session.createCriteria(User.class);
		List<User> users = cr.list();
		return users;
	}

	@Override
	public User getUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		
		if(user == null) {
			user = new User();
		}
		return user;
	}

	@Override
	public User saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		int id =  (int) session.save(user);
		return user; 
	}

	@Override
	public User updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
		return user; 
	}

	@Override
	public User deleteUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(user);
		return user;
	}

}
