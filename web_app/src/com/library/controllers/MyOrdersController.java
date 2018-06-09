package com.library.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.library.binding.Order;
import com.library.binding.SignUpUser;
import com.library.mysql.DbController;

@Controller
public class MyOrdersController {

	@RequestMapping(value = "/orders" , method = RequestMethod.POST)
	public ModelAndView orders(HttpSession session) {
		
		
		ModelAndView orders_view = new ModelAndView("my_orders_window");
		
		
		SignUpUser signed = (SignUpUser) session.getAttribute("signed_user");
		
		DbController db = new DbController() ;
		
		// get orders from database 
		List<Order> orders = db.get_user_order(signed) ; 
		
		// send orders to front end 
		orders_view.addObject("orders", orders) ;
		
		return orders_view;
	}
}
