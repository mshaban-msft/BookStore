package com.library.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.library.binding.SignUpUser;
import com.library.mysql.DbController;

@Controller
public class AccountController {
	
	@RequestMapping(value = "/account" , method = RequestMethod.POST)
	public ModelAndView account(HttpSession session) {
		
		// already signed user info
		SignUpUser signed_user = (SignUpUser)session.getAttribute("signed_user") ;
		
		ModelAndView view = new ModelAndView("account_window") ;
		
		// send user info to front end 
		view.addObject("signed_user", signed_user) ;
		
		return view ;
	}
	
	@RequestMapping(value = "/account/edit" , method = RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute("edit_user") SignUpUser user , BindingResult result , HttpSession session) throws DataAccessException, Exception {
		
		ModelAndView view = new ModelAndView("account_window") ;
		
		// already signed user info
		SignUpUser signed_user = (SignUpUser)session.getAttribute("signed_user") ;
		
		DbController controller = new DbController() ;
		// update user info in database 
		controller.update_user(signed_user, user);
		
		// change user session info to updated info
		session.setAttribute("signed_user", user);
		
		// return new view with updated info 
		return view ;
	}
	
}
