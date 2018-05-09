package com.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PubOrdersController {

	
	@RequestMapping(value = "/publiser_orders" , method = RequestMethod.POST)
	public ModelAndView orders() {
		ModelAndView pub_orders_view = new ModelAndView("pub_orders_window");
		return pub_orders_view;
	}
	
	
}
