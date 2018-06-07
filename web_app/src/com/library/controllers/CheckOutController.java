package com.library.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

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
import com.library.binding.Cart;
import com.library.binding.SignUpUser;
import com.library.mysql.DbController;
import com.library.parsing.JsonParser;

@Controller
public class CheckOutController {

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		binder.registerCustomEditor(Date.class, "expiryDate", new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/checkout" , method = RequestMethod.POST)
	public ModelAndView cart(@ModelAttribute("cart") Cart cart ) {
		
		ModelAndView view = new ModelAndView("checkout_window") ;
		
		// add cart info to ceckout window 
		view.addObject("cart", cart) ;
		
		return view ;
	}
	
	@RequestMapping(value = "/checkout/submit" , method = RequestMethod.POST)
	public ModelAndView checkout(@ModelAttribute("cart") Cart cart , @ModelAttribute("card") CardInfo info , HttpSession session) {
		
		ModelAndView view = new ModelAndView(new RedirectView("/Library/cart")) ;

		//TODO check whether credit card have enough money  
		
		// already signed user info 
		SignUpUser signed = (SignUpUser)session.getAttribute("signed_user") ;
		
		DbController db = new DbController() ;
			
		//add all books in cart to purchases in database 
		db.checkout(signed, cart);
		
		// get books from user's cart
		cart = new Cart() ;
				
		// send books in cart to front end 
		view.addObject("cart", JsonParser.instance().cart_to_json(cart)) ;
		
		return view ;
	}

	
}
