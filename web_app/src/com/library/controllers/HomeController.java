package com.library.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.library.binding.Book;
import com.library.binding.Search;
import com.library.mysql.DbController;

@Controller
public class HomeController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		binder.registerCustomEditor(Date.class, "date", new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/home" , method = RequestMethod.GET)
	public ModelAndView signUp () {
		ModelAndView home_view = new ModelAndView("home_window") ;
		return home_view ;
	}
	
	@RequestMapping(value = "/home/addBook" , method = RequestMethod.POST)
	public ModelAndView addBook (@ModelAttribute("new_book") Book book , BindingResult result) {
	    DbController controller = new DbController();
		controller.insert_book(book);

		ModelAndView home_view = new ModelAndView("home_window") ;
		return home_view ;
	}
	
	@RequestMapping(value = "/home/search" , method = RequestMethod.POST)
	public ModelAndView addBook (@ModelAttribute("search") Search search) {
		search.print();
		ModelAndView home_view = new ModelAndView("home_window") ;
		return home_view ;
	}
	
	
	
	
}
