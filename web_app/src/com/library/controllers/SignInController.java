package com.library.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.library.binding.SignInUser;
import com.library.binding.SignUpUser;
import com.library.checkers.EmailChecker;
import com.library.mysql.DbController;


@Controller
public class SignInController {
	
	/* global attributes */
	

	@RequestMapping(value = "/signin" , method = {RequestMethod.POST , RequestMethod.GET} )
	public ModelAndView signIn (HttpSession session) {		
		session.removeAttribute("signed_user");
		
		ModelAndView sign_view = new ModelAndView("signin_window") ;
		sign_view.addObject("error", "#");
		return sign_view ;
	}

	@RequestMapping(value = "/signin/submit" , method = RequestMethod.POST)
	public ModelAndView signIn_submit (@ModelAttribute("signInUser") SignInUser user , HttpSession session) throws Exception {
		
		DbController db = new DbController();
		String user_exist_password_error = db.sign_in(user) ;
		
		EmailChecker checker = new EmailChecker() ;
		String error = checker.check_signIn_valid(user) ;
		
		if(error.isEmpty())
			error = user_exist_password_error ;
		
		/* validate user account */
		if(!error.isEmpty()) {
			ModelAndView sign_view = new ModelAndView("signin_window") ;
			sign_view.addObject("error" , error) ;
			return sign_view;			
		}
		else {
			session.setAttribute("signed_user", db.get_user_data(user));
			return new ModelAndView(new RedirectView("/Library/home"));			
		}
	}
	
	
}
