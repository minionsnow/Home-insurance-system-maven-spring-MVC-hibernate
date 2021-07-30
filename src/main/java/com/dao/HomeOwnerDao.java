package com.dao;


import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.to.HomeOwner;

public class HomeOwnerDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public int addHomeOwner(HomeOwner u,HttpSession hsession) {
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
