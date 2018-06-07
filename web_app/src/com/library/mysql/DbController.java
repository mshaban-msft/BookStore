package com.library.mysql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.library.binding.Book;
import com.library.binding.Cart;
import com.library.binding.Order;
import com.library.binding.PubOrder;
import com.library.binding.Search;
import com.library.binding.SignInUser;
import com.library.binding.SignUpUser;
import com.library.enums.UserAdmin;


/*
 * use like that :- 
 * 					
 * 	 ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
 *
 *   DbController controller = 
 *        (DbController)context.getBean("DbController");	
 * 
 * */


public class DbController {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("gen.xml"); 
	private DataSource dataSource = (DataSource) context.getBean("dataSource") ; 
    private JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource) ;
   
    public void insert_book(Book book) {
    	String sql = "insert into book "
    			+ "(" + "ISBN ," + "Title ," + "Publication_Year ," + "Price ,"
    			+ "Category ," + "Quantity ," + "Threshold ," + "Publisher " + ") " 
    			+ "values ( ? , ? , ? , ? , ? , ? , ? , ?  )" ;
		String isbn = String.valueOf(book.getIsbn()) ;
		String title = book.getTitle() ;
		String date = String.valueOf(new java.sql.Date(book.getdate().getTime())) ;
		String price = String.valueOf(book.getPrice()) ;
		String category = book.getCategory() ;
		String quantity = String.valueOf(book.getQuantity()) ;
		String threshold = String.valueOf(book.getThershold()) ;
		String publisher = book.getPublisher() ;
		String author = book.getAuthor() ;
		
		this.jdbcTemplateObject.update(sql , isbn , title , date , price 
				, category , quantity , threshold , publisher)  ;
		
		sql = "insert into book "
				+ "(" + "ISBN ," + "Name " + ") " 
				+ "values ( ? , ? )" ;

		this.jdbcTemplateObject.update(sql , isbn , author)  ;
		
    }
    
    public String add_user(SignUpUser user) {
    	String userName = user.getUserName() ;
    	String password = user.getPassword() ;
    	String firstName = user.getFirstName() ;
    	String lastName = user.getLastName() ;
    	String email = user.getEmail() ;
    	String phone = user.getPhone() ;
    	String address = user.getAddress() ;
    	String userAdmin = String.valueOf(UserAdmin.USER);

    	if(check_user_exist(email))
    		return "User already exists" ;
    
    	
    	String sql = "insert into customer "
    			+ "( " + "Email ," + "Password ," + "User_Name ," + "Acount_Type ," + "First_Name ," + "Last_Name ,"
    			+ "Phone ," + "Address " + ") " 
    			+ "values ( ? , ? , ? , ?  , ? , ? , ? , ? )" ;
    	
    	this.jdbcTemplateObject.update(sql , email , password , userName , userAdmin , firstName , lastName 
    			, phone , address)  ;

    	return "" ;
    }
    
    
    public String sign_in(SignInUser user) {
    	if(!check_user_exist(user.getEmail()))
    		return "User does not exist please sign up" ;
    	else {
    		String sql = "select Password from customer "
        			+ " where Email = ? " ;
    		String password = jdbcTemplateObject.queryForObject(sql, new String[]{user.getEmail()} , String.class);        	
    		if(!password.equals(user.getPassword()))
    			return "Password is incorrect" ;
    	}
    	return "" ;
    }
    
    public List<Book> get_books() {
    	String sql = "select * from book" ;
    	return  this.jdbcTemplateObject.query(sql, new BookMapper());
    }
    
    public List<Book> get_search_books(Search search) {
    	String sql = "";
    	
    	if(search.getSearchCriteria().equals("Title") )
    		sql = "select * from book where title = \'" + search.getSearchTerm() + "\'";
    	else if(search.getSearchCriteria().equals("Publisher") )
    		sql = "select * from book where publisher = \'" + search.getSearchTerm() + "\'";	
    	//TODO search with authors
    	else
    		return Collections.emptyList() ;
    	
    	return  this.jdbcTemplateObject.query(sql, new BookMapper());
    }
    
    
    public void add_to_cart(Book book , SignUpUser user) {
    	String sql = "insert into customer_cart "
    			+ "(" + "Email ," + "ISBN" + " ) "  
    			+ "values ( ? , ? )" ;
    	this.jdbcTemplateObject.update(sql , user.getEmail() , book.getIsbn() )  ;
    }
    
    
    public Cart get_cart(SignUpUser user) {
    	
    	String sql = "select ISBN from customer_cart where Email = ?" ;
    	List<Integer> cart_book = (List<Integer>) this.jdbcTemplateObject.queryForList(sql , Integer.class , user.getEmail()  );
    	
    	ArrayList<Book> result = new ArrayList<Book>() ; 
    	for(Integer s : cart_book) {
    		
    		sql = "select * from book where ISBN = ?" ;
    		
    		Book to_add = this.jdbcTemplateObject.queryForObject(sql, new BookMapper() , s) ;
    		
    		
    		result.add(to_add) ;
    	}
    
    	return new Cart(result) ;
    		
    }
    
    
    public void checkout (SignUpUser signed , Cart cart) {
    	for (Book book : cart.getBooks()) {
    		
    		// update total price of each book 
    		book.setPrice(book.getQuantity() * book.getPrice());

    		String sql = "insert into customer_purchases (Email , ISBN , Order_Date , Quantity , Total_Price) "
    				   + "values ( ? , ? , ? , ? , ? )" ;
    		
    		// insert order in purchases in database 
    		this.jdbcTemplateObject.update(sql , signed.getEmail() , book.getIsbn() 
    				, new java.sql.Date(new Date().getTime()) , book.getQuantity() , book.getPrice() )  ;
    	}
    	
    	// empty cart of the user 
    	String sql = "Delete from customer_cart "
    			+ "Email = ? " ;
    	this.jdbcTemplateObject.update(sql , signed.getEmail() )  ;
    	
    }
    
    
    
    public void update_user(SignUpUser signed , SignUpUser updated) {
    	String sql = "update custiomer "
    			+ "set Email = ? , Password = ? , User_Name = ?  , Acount_Type = ? ," 
    			+ "First_Name = ?  , Last_Name = ? , Address = ? , Phone = ? "
    			+ "where Email = ?" ;
    	this.jdbcTemplateObject.update(sql , updated.getEmail() , updated.getPassword() , updated.getUserName() , updated.getUserAdmin()
    									, updated.getFirstName() , updated.getLastName() , updated.getAddress() , updated.getPhone()
    									, signed.getEmail() ) ;	
    }
    
    
    public SignUpUser get_user_data(SignInUser user) {
    	String sql = "select * from customer where Email = \'" + user.getEmail() + "\'" ;
    	return this.jdbcTemplateObject.queryForObject(sql, new UserMapper());
    }
    
    
    public List<Order> get_user_order (SignUpUser signed) {
    	String sql = "select * from customer_purchases where Email = ? " ;
    	return this.jdbcTemplateObject.query(sql ,  new OrderMapper() , signed.getEmail() ) ;
    }
    
    public List<PubOrder> get_publish_order () {
    	String sql = "select * from publisher_orders " ;
    	return this.jdbcTemplateObject.query(sql, new PubOrderMapper()) ;
    }
    
    public void add_publish_order (PubOrder order) {
    	String sql = "insert into publisher_orders (ISBN , Publisher_Name , Quantity ) "
    			+ "values ( ? , ? , ? ) " ;
    	this.jdbcTemplateObject.update(sql,  order.getIsbn() , order.getPublisherName() , order.getQuantity() ) ;
    }
     
    /*
     * return string error if not exist or 
     * exist and password is incorrect 
     * 
     * **/
    public boolean check_user_exist (String email) {
    	String sql = "select count(*) from customer " 
    			+ " where Email = ? " ;
    	Integer coun = jdbcTemplateObject.queryForObject(sql, new String[]{email} , Integer.class);
    	return coun >= 1  ;
    }
    

    
}
