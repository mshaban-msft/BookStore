package com.library.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.library.binding.Book;
import com.library.binding.Search;
import com.library.binding.SignUpUser;
import com.library.mysql.DbController;
import com.library.parsing.JsonParser;

@Controller
public class InventoryController {
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		binder.registerCustomEditor(Date.class, "date", new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/manage_inventory" , method = RequestMethod.GET)
	public ModelAndView inventory(HttpSession session) {
		
		SignUpUser signed = (SignUpUser)session.getAttribute("signed_user") ;
		
		// check user info for security
		if(signed == null) {
			ModelAndView sign_view = new ModelAndView("signin_window") ;
			return sign_view ;
		}
		
		DbController db = new DbController() ;
		ModelAndView inve_view = new ModelAndView("mng_inventory_window") ;
		
		List<Book> books = db.get_books() ;
		
		inve_view.addObject("bookList", JsonParser.instance().books_to_json(books)) ;
		
		return inve_view ;
		
	}
	
	@RequestMapping(value = "/manage_inventory/search" , method = RequestMethod.POST)
	public ModelAndView addBook (@ModelAttribute("search") Search search ) {
		
		ModelAndView inve_view = new ModelAndView("mng_inventory_window") ;
		DbController db = new DbController() ;
		
		//TODO get only needed books from search Remain author search 
		List<Book> books = db.get_search_books(search) ;
		
		// send json value of book list to front end
		inve_view.addObject("bookList", JsonParser.instance().books_to_json(books)) ;
		
		return inve_view ;
	}
	
	@RequestMapping(value = "/manage_inventory/addBook" , method = RequestMethod.POST)
	public ModelAndView addBook (@ModelAttribute("new_book") Book book) {
	    
		DbController db = new DbController() ;
		
		// add book to user cart in database 
		db.insert_book(book);
		
		ModelAndView inve_view = new ModelAndView("mng_inventory_window") ;
		
		List<Book> books = db.get_books() ;
		
		// send json value of book list to front end
		inve_view.addObject("bookList", JsonParser.instance().books_to_json(books)) ;
		
		return inve_view ;
	}
	
	
	@RequestMapping(value = "/manage_inventory/remove" , method = RequestMethod.POST)
	public ModelAndView addBook (@RequestParam("isbn") Integer isbn) {
	    
		DbController db = new DbController() ;
		
		// add book to user cart in database 
		db.delete_book(isbn);
		
		ModelAndView inve_view = new ModelAndView("mng_inventory_window") ;
		
		List<Book> books = db.get_books() ;
		
		// send json value of book list to front end
		inve_view.addObject("bookList", JsonParser.instance().books_to_json(books)) ;
		
		return inve_view ;
	}
	
	
	@RequestMapping(value = "/manage_inventory/edit_book" , method = RequestMethod.POST)
	public ModelAndView editBook (@ModelAttribute("new_book") Book book) {
	    
		DbController db = new DbController() ;
		
		// add book to user cart in database 
		db.edit_book(book);
		
		ModelAndView inve_view = new ModelAndView("mng_inventory_window") ;
		
		List<Book> books = db.get_books() ;
		
		// send json value of book list to front end
		inve_view.addObject("bookList", JsonParser.instance().books_to_json(books)) ;
		
		return inve_view ;
	}
	
}
