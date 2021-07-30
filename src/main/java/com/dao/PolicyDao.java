package com.dao;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.ui.ModelMap;

import com.to.HomeOwner;
import com.to.Policy;
import com.to.UserLocation;
import com.to.UserProperty;
import com.to.ValidationQuote;

public class PolicyDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public int addPolicy(Policy p,HttpSession hsession) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		int id = (int)hsession.getAttribute("userId");
		p.setUserId(id);
		ValidationQuote quote = (ValidationQuote)session.get(ValidationQuote.class,id);
		p.setQuoteId(quote.getQuoteId());
		p.setPolicyKey(7654321-id);		p.setPolicyStatus("Pending");
		p.setPolicyTerm("Terms goes here");
		System.out.println(p);
		hsession.setAttribute("userPolicy", p);
		session.saveOrUpdate(p);;
		session.getTransaction().commit();
		session.close();
		return id;
	}
	
	public boolean buyPolicyInit(ModelMap map,HttpSession hsession) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		int id = (int)hsession.getAttribute("userId");
		UserLocation userLoc = (UserLocation)session.get(UserLocation.class,id);
		UserProperty userProp = (UserProperty)session.get(UserProperty.class,id);
		HomeOwner homeOwner = (HomeOwner)session.get(HomeOwner.class,id);
		ValidationQuote quote = (ValidationQuote)session.get(ValidationQuote.class,id);
		if(userLoc ==null || userProp ==null|| homeOwner==null || quote==null)return false;
		map.addAttribute("userLoc",userLoc);
		map.addAttribute("userProp",userProp);
		map.addAttribute("homeOwner",homeOwner);
		map.addAttribute("validQuote",quote);
		session.close();
		return true;
	}
	
	public void renewPolicy(HttpSession hsession) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		int id = (int)hsession.getAttribute("userId");
		Policy pol = (Policy)session.get(Policy.class,id);
		pol.setPolicyStatus("Renewed");
		hsession.setAttribute("userPolicy", pol);
		session.saveOrUpdate(pol);;
		session.getTransaction().commit();
		session.close();
	}
	
	public void cancelPolicy(HttpSession hsession) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		int id = (int)hsession.getAttribute("userId");
		Policy pol = (Policy)session.get(Policy.class,id);
		pol.setPolicyStatus("Cancelled");
		hsession.setAttribute("userPolicy", pol);
		session.saveOrUpdate(pol);
		session.getTransaction().commit();
		session.close();
	}
	
	public void setTerms(String newterms, HttpSession hsession) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		int id = (int)hsession.getAttribute("userId");
		Policy pol = (Policy)session.get(Policy.class,id);
		pol.setPolicyTerm(newterms);
		hsession.setAttribute("userPolicy", pol);
		session.saveOrUpdate(pol);
		session.getTransaction().commit();
		session.close();
	}
	
}
