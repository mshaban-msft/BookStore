package com.library.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SignUpController {

	/* global attributes */
	

	@RequestMapping(value = "/signup" , method = RequestMethod.POST)
	public ModelAndView signUp () {
		ModelAndView sign_view = new ModelAndView("signup_window") ;
		sign_view.addObject("error", false);
		return sign_view ;
	}
	
	@RequestMapping(value = "/signup/error" , method = RequestMethod.GET)
	public ModelAndView signUp_error () {
		ModelAndView sign_view = new ModelAndView("signup_window") ;
		sign_view.addObject("error", true);
		return sign_view ;
	}
	
	@RequestMapping(value = "/signup/submit" , method = RequestMethod.POST)
	public ModelAndView signUp_submit (@RequestParam Map<String,String> passed_attr) {
		//TODO verify user and bring user data from database 
		boolean user_cred = false ;
		/* validate user account */
		user_cred = true ;
		if(!user_cred) {
			ModelAndView sign_up =  new ModelAndView(new RedirectView("/Library/signup/error")) ;
			return sign_up;			
		}
		else {
			return new ModelAndView(new RedirectView("/Library/home"));			
		}
	}
	
}
