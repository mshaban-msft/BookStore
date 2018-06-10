package com.library.mysql;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.library.binding.Book;
import com.library.binding.Cart;
import com.library.binding.CartElem;
import com.library.binding.Order;
import com.library.binding.PubOrder;
import com.library.binding.Publisher;
import com.library.binding.Search;
import com.library.binding.SignInUser;
import com.library.binding.SignUpUser;
import com.library.encryption.Encryption;
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
	private DataSource dataSource = (DataSource) context.getBean("dataSource");
	private JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);

	public void insert_book(Book book) {
		String sql = "insert into book " + "(" + "ISBN ," + "Title ," + "Publication_Year ," + "Price ," + "Category ,"
				+ "Quantity ," + "Threshold ," + "Publisher " + ") " + "values ( ? , ? , ? , ? , ? , ? , ? , ?  )";
		String isbn = String.valueOf(book.getIsbn());
		String title = book.getTitle();
		String date = book.getdate();
		String price = String.valueOf(book.getPrice());
		String category = book.getCategory();
		String quantity = String.valueOf(book.getQuantity());
		String threshold = String.valueOf(book.getThershold());
		String publisher = book.getPublisher();

		String author = book.getAuthor();

		this.jdbcTemplateObject.update(sql, isbn, title, date, price, category, quantity, threshold, publisher);
		String[] authors = author.split("-");
		for (int i = 0; i < authors.length; i++) {

			sql = "insert into author " + "(" + "ISBN ," + "Name " + ") " + "values ( ? , ? )";

			this.jdbcTemplateObject.update(sql, isbn, authors[i]);
		}

	}

	public void delete_book(Integer isbn) {

		String sql = "delete from book where isbn = ? ";

		this.jdbcTemplateObject.update(sql, isbn);

		sql = "delete from author where isbn = ? ";

		this.jdbcTemplateObject.update(sql, isbn);

	}

	public void edit_book(Book book) {

		String sql = "update book "
				+ "set Title = ? , Publication_Year = ? , Price = ? ,  Category = ? , Publisher = ? , Quantity = ? "
				+ "where ISBN = ? ";

		this.jdbcTemplateObject.update(sql, book.getTitle(), book.getdate(), book.getPrice(), book.getCategory(),
				book.getPublisher() , book.getQuantity() , book.getIsbn());
		
		String[] authors = book.getAuthor().split("-");
		
		sql = "delete from author where isbn = ? ";
		this.jdbcTemplateObject.update(sql, book.getIsbn());

		for (int i = 0; i < authors.length; i++) {

			sql = "insert into author " + "(" + "ISBN ," + "Name " + ") " + "values ( ? , ? )";

			this.jdbcTemplateObject.update(sql, book.getIsbn(), authors[i]);
		}
	}

	public String add_user(SignUpUser user) throws Exception {
		String userName = user.getUserName();

		Encryption enc = new Encryption();
		String password = enc.encrypt(user.getPassword());
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String email = user.getEmail();
		String phone = user.getPhone();
		String address = user.getAddress();
		String userAdmin = String.valueOf(UserAdmin.USER);

		if (check_user_exist(email))
			return "User already exists";

		String sql = "insert into customer " + "( " + "Email ," + "Password ," + "User_Name ," + "Acount_Type ,"
				+ "First_Name ," + "Last_Name ," + "Phone ," + "Address " + ") "
				+ "values ( ? , ? , ? , ?  , ? , ? , ? , ? )";

		this.jdbcTemplateObject.update(sql, email, password, userName, userAdmin, firstName, lastName, phone, address);

		return "";
	}

	public List<SignUpUser> get_users() {

		String sql = "select * from customer";

		return this.jdbcTemplateObject.query(sql, new UserMapper());

	}

	public String sign_in(SignInUser user) throws DataAccessException, Exception {
		if (!check_user_exist(user.getEmail()))
			return "User does not exist please sign up";
		else {
			String sql = "select Password from customer " + " where Email = ? ";

			Encryption enc = new Encryption();

			String password = enc
					.decrypt(jdbcTemplateObject.queryForObject(sql, new String[] { user.getEmail() }, String.class));

			if (!password.equals(user.getPassword()))
				return "Password is incorrect";
		}
		return "";
	}

	public List<Book> get_books() {
		String sql = "select * from book NATURAL LEFT  join author";
		// List<Book> ret = new ArrayList<Book>() ;
		HashMap<Integer, Book> coun = new HashMap<Integer, Book>();
		for (Book book : this.jdbcTemplateObject.query(sql, new BookAuthorMapper())) {
			if (coun.containsKey(book.getIsbn())) {
				System.out.println("found");
				Book temp = coun.get(book.getIsbn());
				book.setAuthor(temp.getAuthor() + "-" + book.getAuthor());
				coun.replace(book.getIsbn(), book);
			} else {
				//System.out.println("NOTTTTTTT Found"+book.getAuthor());
				coun.put(book.getIsbn(), book);
			}
		}
		ArrayList<Book> ret = new ArrayList<Book>(coun.values());
		return ret;
	}

	public List<Book> get_books1() {
		String sql = "select * from book NATURAL LEFT  join author";
		return this.jdbcTemplateObject.query(sql, new BookAuthorMapper());
	}

	public List<Book> get_search_books(Search search) {
		String sql = "";

		if (search.getSearchCriteria().equals("Title"))
			sql = "select * from book NATURAL LEFT  join author where title COLLATE UTF8_GENERAL_CI like \'%" + search.getSearchTerm() + "%\'";
		else if (search.getSearchCriteria().equals("Publisher"))
			sql = "select * from book NATURAL LEFT  join author where publisher = \'%" + search.getSearchTerm() + "%\'";
		// TODO search with authors
		else if (search.getSearchCriteria().equals("Author"))
			sql = "select * from book NATURAL LEFT  join author where name = \'%" + search.getSearchTerm() + "%\'";
		else
			return new ArrayList<Book>();
		
		HashMap<Integer, Book> coun = new HashMap<Integer, Book>();
		for (Book book : this.jdbcTemplateObject.query(sql, new BookAuthorMapper())) {
			if (coun.containsKey(book.getIsbn())) {
				System.out.println("found");
				Book temp = coun.get(book.getIsbn());
				book.setAuthor(temp.getAuthor() + "-" + book.getAuthor());
				coun.replace(book.getIsbn(), book);
			} else {
				coun.put(book.getIsbn(), book);
			}
		}
		ArrayList<Book> ret = new ArrayList<Book>(coun.values());
		return ret;
	}

	public void add_to_cart(Book book, SignUpUser user) {
		String sql = "insert into customer_cart " + "(" + "Email ," + "ISBN ," + " QUANTITY ) " + "values ( ? , ? , ?)";
		this.jdbcTemplateObject.update(sql, user.getEmail(), book.getIsbn(), 1);
	}

	public Cart get_cart(SignUpUser user) {

		String sql = "select * from customer_cart where Email = ?";
		List<CartElem> cart_book = (List<CartElem>) this.jdbcTemplateObject.query(sql, new CartElemMapper(),
				user.getEmail());

		ArrayList<Book> result = new ArrayList<Book>();
		for (CartElem s : cart_book) {

			sql = "select * from book where ISBN = ?";

			Book to_add = this.jdbcTemplateObject.queryForObject(sql, new BookMapper(), s.getIsbn());

			to_add.setQuantity(s.getQuantity());

			result.add(to_add);
		}

		return new Cart(result);

	}

	public void delete_from_cart(SignUpUser signed, Integer Isbn) {
		String sql = "Delete from customer_cart where Email = ? and ISBN = ? limit 1";
		this.jdbcTemplateObject.update(sql, signed.getEmail(), Isbn);
	}

	public void update_cart_quatities(Cart cart, SignUpUser signed) {
		for (Book book : cart.getBooks()) {
			String sql = "update customer_cart" + " set QUANTITY = ? " + " where ISBN = ? and Email = ? ";
			this.jdbcTemplateObject.update(sql, book.getQuantity(), book.getIsbn(), signed.getEmail());
		}
	}

    
    public void checkout (SignUpUser signed) {
    	
    	Cart cart = get_cart(signed) ;
    	
    	for (Book book : cart.getBooks()) {
    		
    		
    		Integer available = this.jdbcTemplateObject.queryForObject("select Quantity from book where ISBN = ?" , Integer.class , book.getIsbn()) ;
    		
    		
    		if(available < book.getQuantity())
    			continue ;
    		
    		
    		// update total price of each book 
    		book.setPrice(book.getQuantity() * book.getPrice());

    		String sql = "insert into customer_purchases (Email , ISBN , Order_Date , Quantity , Total_Price) "
    				   + "values ( ? , ? , ? , ? , ? )" ;
    		
    		// insert order in purchases in database 
    		this.jdbcTemplateObject.update(sql , signed.getEmail() , book.getIsbn() 
    				, new java.sql.Date(new Date().getTime()) , book.getQuantity() , book.getPrice() )  ;
    	
    		sql = "Delete from customer_cart "
        			+ "where ISBN = ? and Email = ?" ;
        	this.jdbcTemplateObject.update(sql  , book.getIsbn() , signed.getEmail() )  ;
        	
        	sql = "update book set Quantity = Quantity - ? where ISBN = ?";
        	this.jdbcTemplateObject.update(sql  , book.getQuantity() ,  book.getIsbn()  )  ;
        			
        	
    	
    	}
    	
    }
    
	public void promote_user(String email) {
		String sql = "update customer set Acount_Type = ? where email = ? ";
		this.jdbcTemplateObject.update(sql, String.valueOf(UserAdmin.ADMIN), email);
	}

	public void update_user(SignUpUser signed, SignUpUser updated) throws DataAccessException, Exception {
		String sql = "update customer " + "set Email = ? , Password = ? , User_Name = ?  ,"
				+ "First_Name = ?  , Last_Name = ? , Address = ? , Phone = ? " + "where Email = ?";

		Encryption enc = new Encryption();

		this.jdbcTemplateObject.update(sql, updated.getEmail(), enc.encrypt(updated.getPassword()),
				updated.getUserName(), updated.getFirstName(), updated.getLastName(), updated.getAddress(),
				updated.getPhone(), signed.getEmail());
	}

	public SignUpUser get_user_data(SignInUser user) throws Exception {
		String sql = "select * from customer where Email = \'" + user.getEmail() + "\'";

		Encryption enc = new Encryption();

		SignUpUser ret = this.jdbcTemplateObject.queryForObject(sql, new UserMapper());

		ret.setPassword(enc.encrypt(user.getPassword()));

		return ret;
	}

	public List<Order> get_user_order(SignUpUser signed) {
		String sql = "select * from (customer_purchases as c join book as b on c.ISBN = b.ISBN) where Email = ? ";
		return this.jdbcTemplateObject.query(sql, new OrderMapper(), signed.getEmail());
	}

	public List<PubOrder> get_publish_order() {
		String sql = "select * from publisher_orders ";
		return this.jdbcTemplateObject.query(sql, new PubOrderMapper());
	}

	public void add_publish_order(PubOrder order) {
		String sql = "insert into publisher_orders (ISBN , Publisher_Name , Quantity ) " + "values ( ? , ? , ? ) ";
		this.jdbcTemplateObject.update(sql, order.getIsbn(), order.getPublisherName(), order.getQuantity());
	}

	public void delete_publish_order(Integer order) {
		String sql = "delete from publisher_orders where ISBN = ?";
		this.jdbcTemplateObject.update(sql, order);
	}

	public void upgrade_user(SignUpUser signed) {
		String sql = "update customer Acount_Type = ? where Email = ? ";
		this.jdbcTemplateObject.update(sql, UserAdmin.ADMIN, signed.getEmail());
	}

	public void add_publisher(Publisher publisher) {
		String sql = "insert into publisher (Name , Address , Phone) " + "values ( ? , ? , ? )";
		this.jdbcTemplateObject.update(sql, publisher.getName(), publisher.getAddress(), publisher.getPhone());
	}

	public List<Publisher> get_publishers() {
		String sql = "select * from publisher";
		return this.jdbcTemplateObject.query(sql, new PubMapper());
	}

	/*
	 * return string error if not exist or exist and password is incorrect
	 * 
	 **/
	public boolean check_user_exist(String email) {
		String sql = "select count(*) from customer " + " where Email = ? ";
		Integer coun = jdbcTemplateObject.queryForObject(sql, new String[] { email }, Integer.class);
		return coun >= 1;
	}

}
