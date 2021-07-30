package com.dao;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.to.Admin;
import com.to.User;

@SuppressWarnings("deprecation")
public class AdminDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public int checkAdminCred(Admin u) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		Admin admin = AdminDao.checkAdmin(u,session);
		if(admin==null)return -1;
		session.close();
		return admin.getAdminID();
	}
	
	@SuppressWarnings("rawtypes")
	public static Admin checkAdmin(Admin u, Session session) {
		Query query = session.createQuery("from Admin where adminname=:adminname and password=:password");
		query.setParameter("adminname", u.getAdminname());
		query.setParameter("password", u.getPassword());
		Admin admin = (Admin) query.uniqueResult();
		return admin;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void selectUser(HttpSession hsession) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User");
		List<User> userList = query.list();
		hsession.setAttribute("userList", userList);
		LinkedHashMap<Integer,String> userListMap = new LinkedHashMap<Integer,String>();
		for(User u:userList) {
			userListMap.put(u.getUserID(),u.getUsername());
		}
		hsession.setAttribute("userListMap", userListMap);
	}
}
