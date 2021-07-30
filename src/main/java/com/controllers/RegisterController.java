package com.controllers;

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

import com.dao.UserDao;
import com.to.User;

@Controller
@EnableWebMvc
public class RegisterController {
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = "registerUser", method = RequestMethod.GET)
	public String showRegister(Model model) {
		System.out.println("user register");
		model.addAttribute("userCommand", new User());
		return "registerUser";
	}
	
	@RequestMapping(value = "addUser",method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("userCommand")User user,BindingResult bindingResult,ModelMap map) {
		System.out.println("herer");
		if(bindingResult.hasErrors()) {
			System.out.println("herer");
			return "registerUser";
		}
		map.addAttribute("user", user);
		int id = userDao.addUser(user);
		if(id==-1) {
			map.addAttribute("errorMessageRegister", "username already exist");
			return "registerUser";
		}
		System.out.println(id);
		map.addAttribute("errorMessageRegister", "Succesfully Registered");
		return "registerUser";
	}
}
