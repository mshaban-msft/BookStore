package com.library.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.library.binding.Publisher;
import com.library.mysql.DbController;

@Controller
public class PubController {

	@RequestMapping(value = "/manage_publishers" , method = RequestMethod.GET)
	public ModelAndView publisher() {
		
		ModelAndView view = new ModelAndView("manage_pub_window") ;
		
		DbController db = new DbController() ;
		
		List<Publisher> publishers = db.get_publishers() ;
		
		view.addObject("publishers", publishers) ;
		
		return view ;
	}
	
	
	@RequestMapping(value = "/manage_publishers/add" , method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("publisher") Publisher publisher) {
		
		ModelAndView view = new ModelAndView(new RedirectView("/Library/manage_publishers")) ;
		
		DbController db = new DbController() ;
		
		db.add_publisher(publisher) ;
		
		return view ;
	}
	
}
