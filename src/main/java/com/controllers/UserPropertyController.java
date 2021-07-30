package com.controllers;

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

import com.dao.UserPropertyDao;
import com.to.UserProperty;

@Controller
@EnableWebMvc
public class UserPropertyController {
	
	@Autowired
	UserPropertyDao userPropertyDao;
	
	@RequestMapping(value = "property", method = RequestMethod.GET)
	public String showRegister(Model model) {
		model.addAttribute("userPropertyCommand", new UserProperty());
		return "property";
	}
	
	@RequestMapping(value = "addUserProperty",method = RequestMethod.POST)
	public String addTrainee(@Valid @ModelAttribute("userPropertyCommand")UserProperty userProp,BindingResult bindingResult,ModelMap map,HttpSession hsession) {
		if(bindingResult.hasErrors()) {
			return "property";
		}
		int id = userPropertyDao.addUserProperty(userProp,hsession);
		System.out.println(id);
		map.addAttribute("filledStatProp", "Filled succesfully");
		return "property";
	}
}
