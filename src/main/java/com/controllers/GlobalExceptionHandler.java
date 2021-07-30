package com.controllers;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class GlobalExceptionHandler {
	
	private static final Log logger = LogFactory.getLog(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value = Exception.class)
	public String handle(HttpServletRequest req,Exception e) {
		logger.info("Request "+ req.getRequestURL() + "Threw an Exception", e);
		return "error";
	}
}
