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

import com.dao.UserLocationDao;
import com.to.UserLocation;

@Controller
@EnableWebMvc
public class UserLocationController {
	
	@Autowired
	UserLocationDao userLocationDao;
	
	@RequestMapping(value = "location", method = RequestMethod.GET)
	public String showRegister(Model model) {
		model.addAttribute("userLocationCommand", new UserLocation());
		return "location";
	}
	
	@RequestMapping(value = "addUserLocation",method = RequestMethod.POST)
	public String addTrainee(@Valid @ModelAttribute("userLocationCommand")UserLocation userLoc,BindingResult bindingResult,ModelMap map,HttpSession hsession) {
		if(bindingResult.hasErrors()) {
			System.out.println("has errors");
			return "location";
		}
		hsession.setAttribute("userLocation", userLoc);
		int id = userLocationDao.addUserLocation(userLoc,hsession);
		System.out.println(id);
		map.addAttribute("filledStat", "Filled succesfully");
		return "location";
	}

}
