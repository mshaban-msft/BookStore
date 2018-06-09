package com.library.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.binding.Book;
import com.library.binding.Search;
import com.library.binding.SignUpUser;
import com.library.mysql.DbController;
import com.library.parsing.JsonParser;

@Controller
public class HomeController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		binder.registerCustomEditor(Date.class, "date", new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/home" , method = RequestMethod.GET)
	public ModelAndView signUp (HttpSession session) {
		
		SignUpUser signed = (SignUpUser)session.getAttribute("signed_user") ;
		
		// check user info for security
		if(signed == null) {
			ModelAndView sign_view = new ModelAndView("signin_window") ;
			return sign_view ;
		}
		
		ModelAndView home_view = new ModelAndView("home_window") ;
		DbController db = new DbController() ;
		
		//TODO get only trended books 
		List<Book> books = db.get_books() ;

		// send json value of book list to front end
		home_view.addObject("bookList", JsonParser.instance().books_to_json(books)) ;
		
		return home_view ;
	}
	
	@RequestMapping(value = "/home/addBook" , method = RequestMethod.POST)
	public ModelAndView addBook (@ModelAttribute("new_book") Book book , BindingResult result , HttpSession session) {
	    
		DbController db = new DbController() ;
		
		// already signed user info 
		SignUpUser signed = (SignUpUser)session.getAttribute("signed_user") ;
		
		// add book to user cart in database 
		db.add_to_cart(book, signed);
		
		
		ModelAndView home_view = new ModelAndView("home_window") ;
		
		//TODO get only trended books 
		List<Book> books = db.get_books() ;
		
		// send json value of book list to front end
		home_view.addObject("bookList", JsonParser.instance().books_to_json(books)) ;
		
		return home_view ;
	}
	
	
	@RequestMapping(value = "/home/search" , method = RequestMethod.POST)
	public ModelAndView addBook (@ModelAttribute("search") Search search ) {
		
		ModelAndView home_view = new ModelAndView("home_window") ;
		DbController db = new DbController() ;
		
		//TODO get only needed books from search Remain author search 
		List<Book> books = db.get_search_books(search) ;
		
		// send json value of book list to front end
		home_view.addObject("bookList", JsonParser.instance().books_to_json(books)) ;
		
		return home_view ;
	}
	
	
}
