package com.library.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.library.binding.SignUpUser;

@Controller
public class AccountController {
	
	@RequestMapping(value = "/account" , method = RequestMethod.POST)
	public ModelAndView account(HttpSession session) {
		// TODO get user data from db 
		SignUpUser signed_user = (SignUpUser)session.getAttribute("signed_user") ;
		ModelAndView view = new ModelAndView("account_window") ;
		view.addObject("signed_user", signed_user) ;
		return view ;
	}
	
	@RequestMapping(value = "/account/edit" , method = RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute("edit_user") SignUpUser user , BindingResult result) {
		
		ModelAndView view = new ModelAndView("account_window") ;
		// TODO edit in user data in db 
		return view ;
	}
	
}
