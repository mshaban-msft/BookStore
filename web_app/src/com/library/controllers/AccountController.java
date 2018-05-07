package com.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
	
	@RequestMapping(value = "/account" , method = RequestMethod.POST)
	public ModelAndView account() {
		ModelAndView view = new ModelAndView("account_window") ;
		return view ;
	}
	
}
