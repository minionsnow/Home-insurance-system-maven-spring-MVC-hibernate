package com.controllers;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.dao.AdminDao;
import com.dao.UserDao;
import com.to.Admin;
import com.to.AdminMod;
import com.to.Policy;
import com.to.User;

@Controller
@EnableWebMvc
public class MyController {
	
	@Autowired
	UserDao userDao;
	@Autowired
	AdminDao adminDao;
	
	@RequestMapping("/")
	public String showHome() {
		System.out.println("home");
		return "home";
	}
	
	@RequestMapping("home")
	public String showHomePage() {
		System.out.println("home");
		return "home";
	}
	
	@RequestMapping("userLogin")
	public String userLogin(Model model) {
		System.out.println("user Login");
		model.addAttribute("userCredCommand", new User());
		return "userLogin";
	}
	
	@RequestMapping(value = "userLoginNew",method = RequestMethod.POST)
	public String isValidUser(@Valid @ModelAttribute("userCredCommand")User user,BindingResult bindingResult,ModelMap map,HttpSession hsession) {
		if(bindingResult.hasErrors()) {
			return "userLogin";
		}
		String page = "userLogin";
		int id = userDao.checkUserCred(user);
		if(id==-1) {
			map.addAttribute("errorMessage", "Invalod login credentials");
		}
		else {
			hsession.setAttribute("userId",id);
			Policy pol = userDao.checkPolicy(hsession);
			if(pol!=null) {
				hsession.setAttribute("boughtPolicy", true);
				hsession.setAttribute("userPolicy", pol);
			}
			page="getStarted";
		}
		return page;
	}
	
	@RequestMapping("adminLogin")
	public String adminLogin(Model model) {
		System.out.println("admin Login");
		model.addAttribute("adminCredCommand", new Admin());
		return "adminLogin";
	}
	
	@RequestMapping(value = "adminLoginNew",method = RequestMethod.POST)
	public String isValidAdmin(@Valid @ModelAttribute("adminCredCommand")Admin admin,BindingResult bindingResult,ModelMap map,HttpSession hsession,Model model) {
		if(bindingResult.hasErrors()) {
			return "adminLogin";
		}
		String page = "adminLogin";
		int id = adminDao.checkAdminCred(admin);
		if(id==-1) {
			map.addAttribute("errorMessageAdmin", "Invalod login credentials");
		}
		else {
			hsession.setAttribute("adminId",id);
			page="adminLoginView";
			adminDao.selectUser(hsession);;
			model.addAttribute("adminSelectCommand", new AdminMod());
		}
		return page;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "adminLoginView",method = RequestMethod.GET)
	public String adminLoginView(Model model,HttpSession hsession) {
		model.addAttribute("adminSelectCommand", new AdminMod());
		Enumeration<String> enumeration = hsession.getAttributeNames();
		  while (enumeration.hasMoreElements()) {
			  String nextElement = enumeration.nextElement();
		    if(nextElement != "adminId" &&  nextElement != "userListMap")hsession.removeAttribute(nextElement);
		  }
		return "adminLoginView";
	}
	
	@RequestMapping(value = "adminLoginView",method = RequestMethod.POST)
	public String adminLogin(@ModelAttribute("adminSelectCommand")AdminMod adminMod,HttpSession hsession) {
		hsession.setAttribute("userId", adminMod.getUserId());
		Policy pol = userDao.checkPolicy(hsession);
		if(pol!=null) {
			hsession.setAttribute("boughtPolicy", true);
			hsession.setAttribute("userPolicy", pol);
		}
		return "getStarted";
	}
	
}
