package com.dao;


import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.to.Policy;
import com.to.User;;

@SuppressWarnings("deprecation")
public class UserDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public int addUser(User u) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		if(UserDao.checkUser(u,session)==null) {
			int id = (int) session.save(u);
			session.getTransaction().commit();
			session.close();
			return id;
		}
		System.out.println("Already exist");
		session.close();
		return -1;
	}
	
	public int checkUserCred(User u) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		User user = UserDao.checkUser(u,session);
		if(user==null)return -1;
		session.close();
		return user.getUserID();
	}
	
	@SuppressWarnings({"rawtypes" })
	public static User checkUser(User u, Session session) {
		Query query = session.createQuery("from User where username=:username");
		query.setParameter("username", u.getUsername());
		User user = (User) query.uniqueResult();
		return user;
	}
	public Policy checkPolicy(HttpSession hsession) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		int id = (int)hsession.getAttribute("userId");
		Policy pol = (Policy)session.get(Policy.class,id);
		return pol;
	}
	
}
