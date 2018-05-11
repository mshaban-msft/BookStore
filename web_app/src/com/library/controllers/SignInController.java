package com.library.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.library.binding.SignInUser;
import com.library.checkers.EmailChecker;


@Controller
public class SignInController {
	
	/* global attributes */
	

	@RequestMapping(value = "/signin" , method = RequestMethod.GET)
	public ModelAndView signIn () {	
		ModelAndView sign_view = new ModelAndView("signin_window") ;
		sign_view.addObject("error", "#");
		return sign_view ;
	}

	@RequestMapping(value = "/signin/submit" , method = RequestMethod.POST)
	public ModelAndView signIn_submit (@ModelAttribute("signInUser") SignInUser user) {
		
		user.print();
		
		EmailChecker checker = new EmailChecker() ;
		
		String error = checker.check_signIn_valid(user) ;
		/* validate user account */
		if(!error.isEmpty()) {
			ModelAndView sign_view = new ModelAndView("signin_window") ;
			sign_view.addObject("error" , error) ;
			return sign_view;			
		}
		else {
			return new ModelAndView(new RedirectView("/Library/home"));			
		}
	}
	
	
}
