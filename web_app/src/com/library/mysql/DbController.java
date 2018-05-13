package com.library.mysql;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.library.binding.Book;
import com.library.binding.SignInUser;
import com.library.binding.SignUpUser;
import com.library.credentials.UserAdmin;


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
    	String sql = "insert into Book "
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
		
    	int error = this.jdbcTemplateObject.update(sql , isbn , title , date , price 
    			, category , quantity , threshold , publisher)  ;
    	
    	System.out.println("insertion_book is good if 1 is " + error);
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
    	
    	
    	String sql = "insert into Credentials "
    			+ "(" + "Email ," + "Password ," + "User_Name ," + "Acount_Type" + " ) "  
    			+ "values ( ? , ? , ? , ? )" ;
    	this.jdbcTemplateObject.update(sql , email , password , userName , userAdmin )  ;
    	
    	
    	sql = "insert into Customer "
    			+ "( "  + "First_Name ," + "Last_Name ," + "Email , "
    			+ "Phone ," + "Address " + ") " 
    			+ "values ( ? , ? , ? , ? , ?  )" ;
    	int error = this.jdbcTemplateObject.update(sql  , firstName , lastName 
    			, email , phone , address)  ;
    	
    	System.out.println("insertion_user is good if 1 is " + error);
    	
    	return "" ;
    }
    
    
    public String sign_in(SignInUser user) {
    	if(!check_user_exist(user.getEmail()))
    		return "User does not exist please sign up" ;
    	else {
    		String sql = "select Password from Credentials "
        			+ " where Email = ? " ;
    		String password = jdbcTemplateObject.queryForObject(sql, new String[]{user.getEmail()} , String.class);        	
    		if(!password.equals(user.getPassword()))
    			return "Password is incorrect" ;
    	}
    	return "" ;
    }
    
    /*
     * return string error if not exist or 
     * exist and password is incorrect 
     * 
     * **/
    public boolean check_user_exist (String email) {
    	String sql = "select count(*) from Customer "
    			+ " where Email = ? " ;
    	Integer coun = jdbcTemplateObject.queryForObject(sql, new String[]{email} , Integer.class);
    	return coun >= 1  ;
    }
    

    
}
