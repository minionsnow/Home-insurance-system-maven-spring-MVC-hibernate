package com.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserMenuController {
	
	@RequestMapping(value = "getStarted", method = RequestMethod.GET)
	public String startModule() {
		System.out.println("get started");
		return "getStarted";
	}
	
	@RequestMapping(value = "getQuote", method = RequestMethod.GET)
	public String quoteModule() {
		System.out.println("get quote");
		return "getQuote";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logoutModule(HttpSession session) {
		session.invalidate();
		System.out.println("logout");
		return "logout";
	}
	
	
	@RequestMapping(value = "retrieveQuote", method = RequestMethod.GET)
	public String retrieveModule() {
		System.out.println("retrieve quote");
		return "retrieveQuote";
	}
	
	
	
}
