package com.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyOrdersController {

	@RequestMapping(value = "/orders" , method = RequestMethod.POST)
	public ModelAndView orders() {
		ModelAndView orders_view = new ModelAndView("my_orders_window");
		return orders_view;
	}
}
