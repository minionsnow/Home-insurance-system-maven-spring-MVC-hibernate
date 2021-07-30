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

import com.dao.HomeOwnerDao;
import com.to.HomeOwner;

@Controller
@EnableWebMvc
public class HomeOwnerController {
	
	@Autowired
	HomeOwnerDao homeOwnerDao;
	
	@RequestMapping(value = "homeOwner", method = RequestMethod.GET)
	public String showRegister(Model model) {
		model.addAttribute("homeOwnerCommand", new HomeOwner());
		return "homeOwner";
	}
	
	@RequestMapping(value = "addHomeOwner",method = RequestMethod.POST)
	public String addTrainee(@Valid @ModelAttribute("homeOwnerCommand")HomeOwner homeOwner,BindingResult bindingResult,ModelMap map,HttpSession hsession) {
		if(bindingResult.hasErrors()) {
			return "homeOwner";
		}
		map.addAttribute("homeOwner", homeOwner);
		hsession.setAttribute("homeOwner", homeOwner);
		int id = homeOwnerDao.addHomeOwner(homeOwner,hsession);
		System.out.println(id);
		map.addAttribute("filledStatHome", "Filled succesfully");
		return "homeOwner";
	}
}
