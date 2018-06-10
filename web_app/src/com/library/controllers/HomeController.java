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

import com.library.binding.Book;
import com.library.binding.Search;
import com.library.binding.SignUpUser;
import com.library.enums.UserAdmin;
import com.library.mysql.DbController;
import com.library.parsing.JsonParser;

@Controller
public class HomeController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		binder.registerCustomEditor(Date.class, "date", new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/home", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView signUp(HttpSession session) {

		SignUpUser signed = (SignUpUser) session.getAttribute("signed_user");
		// check user info for security
		if (signed == null) {
			ModelAndView sign_view = new ModelAndView("signin_window");
			return sign_view;
		}

		ModelAndView home_view = new ModelAndView("home_window");
		DbController db = new DbController();

		// TODO get only trended books
		List<Book> books = db.get_books();

		// send json value of book list to front end
		home_view.addObject("bookList", JsonParser.instance().books_to_json(books));
		home_view.addObject("admin_rights", signed.getUserAdmin().equals(UserAdmin.ADMIN) ? 1 : 0);
		home_view.addObject("user_name", signed.getFirstName());

		return home_view;
	}

	@RequestMapping(value = "/home/addBook", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView addBook(@ModelAttribute("new_book") Book book, BindingResult result, HttpSession session) {

		DbController db = new DbController();

		// already signed user info
		SignUpUser signed = (SignUpUser) session.getAttribute("signed_user");
		// check user info for security
		if (signed == null) {
			ModelAndView sign_view = new ModelAndView("signin_window");
			return sign_view;
		}

		// add book to user cart in database
		db.add_to_cart(book, signed);

		ModelAndView home_view = new ModelAndView("home_window");

		// TODO get only trended books
		List<Book> books = db.get_books();

		// send json value of book list to front end
		home_view.addObject("bookList", JsonParser.instance().books_to_json(books));
		home_view.addObject("admin_rights", signed.getUserAdmin().equals(UserAdmin.ADMIN) ? 1 : 0);
		home_view.addObject("user_name", signed.getFirstName());
		//System.out.println();
		return home_view;
	}

	@RequestMapping(value = "/home/search", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView addBook(@ModelAttribute("search") Search search , HttpSession session) {

		// already signed user info
		SignUpUser signed = (SignUpUser) session.getAttribute("signed_user");
		// check user info for security
		if (signed == null) {
			ModelAndView sign_view = new ModelAndView("signin_window");
			return sign_view;
		}
		ModelAndView home_view = new ModelAndView("home_window");
		DbController db = new DbController();

		// TODO get only needed books from search Remain author search
		List<Book> books = db.get_search_books(search);

		// send json value of book list to front end
		home_view.addObject("bookList", JsonParser.instance().books_to_json(books));
		home_view.addObject("admin_rights", signed.getUserAdmin().equals(UserAdmin.ADMIN) ? 1 : 0);
		home_view.addObject("user_name", signed.getFirstName());

		return home_view;
	}

}
