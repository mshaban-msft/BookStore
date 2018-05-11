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

import com.library.binding.CardInfo;

@Controller
public class CheckOutController {

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		binder.registerCustomEditor(Date.class, "expiryDate", new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/checkout" , method = RequestMethod.POST)
	public ModelAndView cart() {
		ModelAndView view = new ModelAndView("checkout_window") ;
		return view ;
	}
	
	@RequestMapping(value = "/checkout/submit" , method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("card") CardInfo info) {
		// TODO call database 
		info.print() ;
		ModelAndView view = new ModelAndView(new RedirectView("/Library/home")) ;
		return view ;
	}
	
}
