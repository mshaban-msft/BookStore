package com.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/home" , method = RequestMethod.GET)
	public ModelAndView signUp () {
		ModelAndView home_view = new ModelAndView("home_window") ;
		return home_view ;
	}
	
}
