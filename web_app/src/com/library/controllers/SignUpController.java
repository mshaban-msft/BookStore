package com.library.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
public class SignUpController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields(new String[] {"userAdmin"});
	}

	@RequestMapping(value = "/signup" , method = {RequestMethod.POST , RequestMethod.GET} )
	public ModelAndView signUp (HttpSession session) {	
		ModelAndView sign_view = new ModelAndView("signup_window") ;
		sign_view.addObject("error", "#");
		return sign_view ;
	}
	
	@RequestMapping(value = "/signup/submit" , method = {RequestMethod.POST , RequestMethod.GET} )
	public ModelAndView signUp_submit (@ModelAttribute("signUpUser") SignUpUser user , HttpSession session) throws Exception {
		
		DbController db = new DbController() ;
		String user_exits_error = db.add_user(user);
		
		EmailChecker checker = new EmailChecker() ;
		
		String error = checker.check_signUp_valid(user) ; 
		
		if(error.isEmpty())
			error = user_exits_error  ;
		
		/* validate user account */
		if(!error.isEmpty()) {
			ModelAndView sign_up_view = new ModelAndView("signup_window") ;
			sign_up_view.addObject("error" , error);
			return sign_up_view;			
		}
		else {
			session.setAttribute("signed_user", db.get_user_data(new SignInUser(user.getEmail(), user.getPassword())));
			return new ModelAndView(new RedirectView("/Library/home"));			
		}
		
	}
	
	
}
