package com.controllers;



import java.util.Calendar;
import java.util.Date;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.dao.PolicyDao;
import com.to.Policy;

@Controller
@EnableWebMvc
public class PolicyController {
	
	@Autowired
	PolicyDao policyDao;
	
	@RequestMapping(value = "buyPolicy", method = RequestMethod.GET)
	public String showRegister(Model model) {
		model.addAttribute("userPolicyCommand", new Policy());
		return "buyPolicy";
	}
	
	@RequestMapping(value = "addPolicy",method = RequestMethod.POST)
	public String addPolicy(@Valid @ModelAttribute("userPolicyCommand")Policy policy,BindingResult bindingResult,ModelMap map,HttpSession hsession) {
		if(bindingResult.hasErrors()) {
			return "buyPolicy";
		}
		if(policy.getEffectiveDate().after(policy.getEndDate())) {
			map.addAttribute("errorFilledStatPolicy","End date must be after Effective Date");
			return "buyPolicy";
		}
		Calendar c= Calendar.getInstance();
		c.add(Calendar.DATE, 60);
		Date d=c.getTime();
		if(policy.getEffectiveDate().before(d)) {
			map.addAttribute("errorFilledStatPolicy","Effective date must be after atleast 60 days from today.");
			return "buyPolicy";
		}
		boolean poss = policyDao.buyPolicyInit(map,hsession);
		if(poss) {
			int id = policyDao.addPolicy(policy,hsession);
			System.out.println(id);
			map.addAttribute("filledStatPolicy", "Filled succesfully");
			hsession.setAttribute("boughtPolicy", true);
		}
		else map.addAttribute("errorFilledStatPolicy","You cannot buy the policy, incomplete details");
		return "buyPolicy";
	}
	
	@RequestMapping(value = "viewPolicy", method = RequestMethod.GET)
	public String viewPolicy(Model model) {
		return "viewPolicy";
	}
	
	@RequestMapping(value = "renewPolicy", method = RequestMethod.GET)
	public String renewPolicy(Model model,HttpSession hsession) {
		policyDao.renewPolicy(hsession);
		return "viewPolicy";
	}
	
	@RequestMapping(value = "cancelPolicy", method = RequestMethod.GET)
	public String cancelPolicy(Model model,HttpSession hsession) {
		policyDao.cancelPolicy(hsession);
		return "viewPolicy";
	}
	
	@RequestMapping(value = "editTerms", method = RequestMethod.GET)
	public String policyTerms(Model model,HttpSession hsession) {	
		return "policyTerm";
	}
	
	@RequestMapping(value = "editTerms", method = RequestMethod.POST)
	public String addPolicyTerms(@RequestParam String newterms,HttpSession hsession) {
		policyDao.setTerms(newterms,hsession);
		return "viewPolicy";
	}
	
}
