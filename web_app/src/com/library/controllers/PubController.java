package com.library.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.library.binding.Publisher;
import com.library.binding.SignUpUser;
import com.library.enums.UserAdmin;
import com.library.mysql.DbController;

@Controller
public class PubController {

	@RequestMapping(value = "/manage_publishers" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView publisher(HttpSession session) {
		
		SignUpUser signed = (SignUpUser)session.getAttribute("signed_user") ;
		// check user info for security
		if(signed == null) {
			ModelAndView sign_view = new ModelAndView("signin_window") ;
			return sign_view ;
		}
		
		ModelAndView view = new ModelAndView("manage_pub_window") ;
		
		DbController db = new DbController() ;
		
		List<Publisher> publishers = db.get_publishers() ;
		
		view.addObject("publishers", publishers) ;
		view.addObject("admin_rights", signed.getUserAdmin().equals(UserAdmin.ADMIN) ? 1 : 0 ) ;
		view.addObject("user_name", signed.getFirstName()) ;
		
		return view ;
	}
	
	
	@RequestMapping(value = "/manage_publishers/add" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView add(@ModelAttribute("publisher") Publisher publisher , HttpSession session) {
		
		SignUpUser signed = (SignUpUser)session.getAttribute("signed_user") ;
		// check user info for security
		if(signed == null) {
			ModelAndView sign_view = new ModelAndView("signin_window") ;
			return sign_view ;
		}
		
		ModelAndView view = new ModelAndView(new RedirectView("/Library/manage_publishers")) ;
		
		DbController db = new DbController() ;
		
		db.add_publisher(publisher) ;
		
		return view ;
	}
	
}
