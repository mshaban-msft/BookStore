package com.library.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class SignInController {
	
	/* global attributes */
	

	@RequestMapping(value = "/signin" , method = RequestMethod.GET)
	public ModelAndView signIn () {
		ModelAndView sign_view = new ModelAndView("signin_window") ;
		sign_view.addObject("stduent_name" , "ahmed") ; 
		sign_view.addObject("error", false);
		return sign_view ;
	}
	
	@RequestMapping(value = "/signin/error" , method = RequestMethod.GET)
	public ModelAndView signIn_error () {
		ModelAndView sign_view = new ModelAndView("signin_window") ;
		sign_view.addObject("stduent_name" , "ahmed") ; 
		sign_view.addObject("error", true);
		return sign_view ;
	}
	
	@RequestMapping(value = "/signin/submit" , method = RequestMethod.POST)
	public ModelAndView signIn_submit (@RequestParam Map<String,String> passed_attr) {
		//TODO verify user and bring user data from database 
		boolean user_cred = false ;
		/* validate user account */
		user_cred = false ;
		if(!user_cred) {
			ModelAndView sign_in =  new ModelAndView(new RedirectView("/Library/signin/error")) ;
			return sign_in;			
		}
		else {
			return new ModelAndView(new RedirectView("/Library/home"));			
		}
	}
	
}
