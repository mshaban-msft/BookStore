package com.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

	@RequestMapping(value = "/cart" , method = RequestMethod.POST)
	public ModelAndView cart() {
		ModelAndView view = new ModelAndView("cart_window") ;
		return view ;
	}
	
}
