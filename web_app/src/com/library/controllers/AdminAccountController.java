package com.library.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.library.binding.SignUpUser;
import com.library.mysql.DbController;

@Controller
public class AdminAccountController {
	
	@RequestMapping(value = "/manage_user_accounts" , method = {RequestMethod.POST , RequestMethod.GET} )
	public ModelAndView accounts(HttpSession session) {
		 

		SignUpUser signed = (SignUpUser)session.getAttribute("signed_user") ;
		
		// check user info for security
		if(signed == null) {
			ModelAndView sign_view = new ModelAndView("signin_window") ;
			return sign_view ;
		}
		
		DbController db = new DbController() ;
		
		List<SignUpUser> users = db.get_users() ;
		
		
		ModelAndView view = new ModelAndView("user_accounts_window") ;
		
		view.addObject("users", users) ;
		
		return view ;
		
	}
	
	@RequestMapping(value = "/manage_user_accounts/promote" , method = {RequestMethod.POST , RequestMethod.GET} )
	public ModelAndView accounts(@RequestParam("email") String email ) {
		
		ModelAndView view = new ModelAndView(new RedirectView("/Library/manage_user_accounts")) ;
		
		DbController db = new DbController() ;
		
		db.promote_user(email) ;
		
		return view ;
	}
		
	
}
