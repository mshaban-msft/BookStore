package com.library.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.library.binding.Order;

@Controller
public class PubOrdersController {

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields(new String[] {"totalPrice"});
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		binder.registerCustomEditor(Date.class, "date", new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/publiser_orders" , method = {  RequestMethod.GET} )
	public ModelAndView orders() {
		ModelAndView pub_orders_view = new ModelAndView("pub_orders_window");
		return pub_orders_view;
	}
	
	@RequestMapping(value = "/publiser_orders/add_order" , method = RequestMethod.POST)
	public ModelAndView add_order(@ModelAttribute("order") Order order) {
		// TODO call database 
		order.print() ;
		ModelAndView view = new ModelAndView(new RedirectView("/Library/publiser_orders")) ;
		return view ;
	}
	
	
	
}
