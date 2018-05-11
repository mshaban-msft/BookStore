package com.library.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.library.binding.SignUpUser;
import com.library.checkers.EmailChecker;

@Controller
public class SignUpController {

	/* global attributes */
	

	@RequestMapping(value = "/signup" , method = RequestMethod.POST)
	public ModelAndView signUp () {
		ModelAndView sign_view = new ModelAndView("signup_window") ;
		sign_view.addObject("error", "#");
		return sign_view ;
	}
	
	@RequestMapping(value = "/signup/submit" , method = RequestMethod.POST)
	public ModelAndView signUp_submit (@ModelAttribute("signUpUser") SignUpUser user) {
		
		user.print();
		
		EmailChecker checker = new EmailChecker() ;
		
		String error = checker.check_signUp_valid(user) ; 
		
		/* validate user account */
		if(!error.isEmpty()) {
			ModelAndView sign_up_view = new ModelAndView("signup_window") ;
			sign_up_view.addObject("error" , error);
			return sign_up_view;			
		}
		else {
			return new ModelAndView(new RedirectView("/Library/home"));			
		}
		
	}
	
	
}
