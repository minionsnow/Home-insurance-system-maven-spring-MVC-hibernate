package com.dao;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.to.UserLocation;

public class UserLocationDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public int addUserLocation(UserLocation u,HttpSession hsession) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		int id = (int)hsession.getAttribute("userId");
		u.setUserId(id);
		session.saveOrUpdate(u);
		session.getTransaction().commit();
		session.close();
		return id;
	}
}
