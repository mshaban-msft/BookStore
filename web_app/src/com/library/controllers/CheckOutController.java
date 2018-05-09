package com.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CheckOutController {

	@RequestMapping(value = "/checkout" , method = RequestMethod.POST)
	public ModelAndView cart() {
		ModelAndView view = new ModelAndView("checkout_window") ;
		return view ;
	}
	
	@RequestMapping(value = "/checkout/submit" , method = RequestMethod.POST)
	public ModelAndView submit() {
		// TODO call database 
		ModelAndView view = new ModelAndView(new RedirectView("/Library/home")) ;
		return view ;
	}
	
}
