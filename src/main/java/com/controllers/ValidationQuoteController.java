package com.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.ValidationQuoteDao;
import com.to.ValidationQuote;

@Controller
public class ValidationQuoteController {
	
	@Autowired
	ValidationQuoteDao validationQuoteDao;
	
	@RequestMapping(value = "quote", method = RequestMethod.GET)
	public String showQuote(ModelMap map,HttpSession hsession) {
		System.out.println("inside quote");
		ValidationQuote quote = validationQuoteDao.addValidattionQuote(hsession);
		map.addAttribute("validQuote",quote);
		if(quote==null)map.addAttribute("errorMesssageValid", "Need to Fill Details First");
		else map.addAttribute("errorMesssageValid", null);
		return "quote";
	}
	
	@RequestMapping(value = "getRetrieveQuote", method = RequestMethod.GET)
	public String showRetrieveQuote(ModelMap map,HttpSession hsession) {
		validationQuoteDao.RetrieveQuote(map,hsession);
		return "getRetrieveQuote";
	}
	
	@RequestMapping(value = "quoteSummary", method = RequestMethod.GET)
	public String showQuoteSummary(ModelMap map,HttpSession hsession) {
		validationQuoteDao.RetrieveQuote(map,hsession);
		return "quoteSummary";
	}
	
	
}
