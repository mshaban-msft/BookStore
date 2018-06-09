package com.library.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.library.binding.Cart;
import com.library.binding.SignUpUser;
import com.library.mysql.DbController;

import com.library.binding.Cart;
import com.library.binding.SignUpUser;
import com.library.mysql.DbController;
import com.library.parsing.JsonParser;

@Controller
public class CartController {

<<<<<<< HEAD
	@RequestMapping(value = "/cart" , method = RequestMethod.GET)
=======
	@RequestMapping(value = "/cart" , method = RequestMethod.POST)
>>>>>>> 37c6f3bd08258e3d59490ef974580c2f065e31df
	public ModelAndView cart(HttpSession session) {
		
		ModelAndView view = new ModelAndView("cart_window") ;
		
		DbController db = new DbController() ;
		SignUpUser signed = (SignUpUser) session.getAttribute("signed_user"); 
		
<<<<<<< HEAD
		
		// check user info for security
		if(signed == null) {
			ModelAndView sign_view = new ModelAndView("signin_window") ;
			return sign_view ;
		}
		
		
=======
>>>>>>> 37c6f3bd08258e3d59490ef974580c2f065e31df
		// get books from user's cart
		Cart cart = db.get_cart(signed) ;
				
		// send books in cart to front end 
		view.addObject("cart", cart) ;
				
<<<<<<< HEAD
		return view ;
	}
	
	

	@RequestMapping(value = "/cart/delete" , method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam("isbn") Integer isbn , HttpSession session) {
		
		DbController db = new DbController() ;
		SignUpUser signed = (SignUpUser) session.getAttribute("signed_user"); 

		
		//TODO delete order from user 
		db.delete_from_cart(signed, isbn);
		
		ModelAndView view = new ModelAndView(new RedirectView("/Library/cart")) ;
		
=======
>>>>>>> 37c6f3bd08258e3d59490ef974580c2f065e31df
		return view ;
	}
	
}
