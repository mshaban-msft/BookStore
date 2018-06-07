package com.library.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.library.binding.Cart;
import com.library.binding.SignUpUser;
import com.library.mysql.DbController;
import com.library.parsing.JsonParser;

@Controller
public class CartController {

	@RequestMapping(value = "/cart" , method = RequestMethod.POST)
	public ModelAndView cart(HttpSession session) {
		
		ModelAndView view = new ModelAndView("cart_window") ;
		
		DbController db = new DbController() ;
		SignUpUser signed = (SignUpUser) session.getAttribute("signed_user"); 
		
		// get books from user's cart
		Cart cart = db.get_cart(signed) ;
				
		// send books in cart to front end 
		view.addObject("cart", cart) ;
				
		return view ;
	}
	
}
