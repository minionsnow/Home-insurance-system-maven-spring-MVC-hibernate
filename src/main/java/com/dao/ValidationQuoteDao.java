package com.dao;



import java.util.Date;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.ui.ModelMap;

import com.to.HomeOwner;
import com.to.UserLocation;
import com.to.UserProperty;
import com.to.ValidationQuote;

public class ValidationQuoteDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public ValidationQuote addValidattionQuote(HttpSession hsession) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		int id = (int)hsession.getAttribute("userId");
		UserProperty userProp = (UserProperty)session.get(UserProperty.class,id);
		UserLocation userLoc = (UserLocation)session.get(UserLocation.class,id);
		if(userProp==null || userLoc==null)return null;
		double dwelling_coverage = ValidationQuoteDao.calculateDwellingCoverage(hsession,session,userProp);
		double premium = ValidationQuoteDao.calculatePremium(hsession,dwelling_coverage,session,userLoc);
		double detached_structures = 0.1*dwelling_coverage;
		double personal_property = 0.6*dwelling_coverage;
		double living_expense = 0.2*dwelling_coverage;
		double medical_expense = 5000;
		double deductible = ValidationQuoteDao.calculatedeductible(hsession,session,userProp);
		ValidationQuote quote = new ValidationQuote(premium, dwelling_coverage, detached_structures, personal_property, living_expense, medical_expense, deductible);
		quote.setUserId(id);
		quote.setQuoteId(id);		
		session.saveOrUpdate(quote);
		session.getTransaction().commit();
		session.close();
		return quote;
	}
	
	public void RetrieveQuote(ModelMap map,HttpSession hsession) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		int id = (int)hsession.getAttribute("userId");
		UserLocation userLoc = (UserLocation)session.get(UserLocation.class,id);
		UserProperty userProp = (UserProperty)session.get(UserProperty.class,id);
		HomeOwner homeOwner = (HomeOwner)session.get(HomeOwner.class,id);
		ValidationQuote quote = (ValidationQuote)session.get(ValidationQuote.class,id);
		map.addAttribute("userLoc",userLoc);
		map.addAttribute("userProp",userProp);
		map.addAttribute("homeOwner",homeOwner);
		map.addAttribute("validQuote",quote);
	}
	
	
	public static double calculatePremium(HttpSession hsession, double dwelling_coverage, Session session,UserLocation userLoc ) {
		double rate = (dwelling_coverage/1000)*5;
		double premium = rate;
		String residenceType = userLoc.getResidenceType();
		switch(residenceType) {
		case "Single_Family_Home":{
			premium = 1.005*premium;
			break;
		}
		case "Condo":{
			premium = 1.0006*premium;
			break;
		}
		case "Townhouse":{
			premium = 1.0007*premium;
			break;
		}
		case "Row_house":{
			premium = 1.0007*premium;
			break;
		}
		case "Duplex":{
			premium = 1.0006*premium;
			break;
		}
		case "Apartment":{
			premium = 1.0006*premium;
			break;
		}
		}
		return Math.ceil(premium/12);
	}
	
	@SuppressWarnings("deprecation")
	public static double calculateDwellingCoverage(HttpSession hsession, Session session,UserProperty userProp) {
		double constructionCost = (int)userProp.getSqFoot()*120;
		Date date = new Date();
		int homeAge = date.getYear() - userProp.getBuiltYear().getYear();
		System.out.println(homeAge);
		double homeValue = constructionCost;
		if(homeAge<5)homeValue = 0.9* homeValue;
		else if(homeAge<10)homeValue = 0.8* homeValue;
		else if(homeAge<20)homeValue = 0.7* homeValue;
		else homeValue = 0.5* homeValue;
		return (int)userProp.getMarketValue()+homeValue;
	}
	
	
	public static double calculatedeductible(HttpSession hsession, Session session,UserProperty userProp) {
		return ((int)userProp.getMarketValue())*0.01;
		
	}
	
}
