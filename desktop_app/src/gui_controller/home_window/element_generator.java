package gui_controller.home_window;

import java.io.FileNotFoundException;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class element_generator {

	/************************************************/
	/* ATTRIBUTES */
	/************************************************/
	
	/* Navigation Bar */
	/**********************************/
	private Button sign_in_out_btn;
	private Button view_account_btn;
	private Button view_cart_btn;
	private Button view_orders_btn;
	private TextField search__books_field;
	private Label window_label;
	
	/* Browse Book Table */
	/**********************************/
	private TextArea inventory_table;
	private Button view_more_btn;
	
	/* Back-end Engine */
	/**********************************/
	
	
	
	
	/************************************************/
	/* INTERFACE METHODS */
	/************************************************/
	public void
	generate_elements() throws FileNotFoundException
	{
		
		/* Navigation Bar */
		/**********************************/
		sign_in_out_btn = new Button("Sign In");
		view_account_btn = new Button("Account");
		view_cart_btn = new Button("Cart");
		view_orders_btn = new Button("Orders");
		search__books_field = new TextField("Search");
		window_label = new Label("BARNES & NOBLE");
		
		/* Browse Book Table */
		/**********************************/
		inventory_table = new TextArea();
		view_more_btn = new Button("More");
		
		/* Back-end Engine */
		/**********************************/

	}
	
	
	
	/************************************************/
	/* GETTERS */
	/************************************************/

	public Button getSign_in_out_btn() {
		return sign_in_out_btn;
	}
	
	public Button getView_account_btn() {
		return view_account_btn;
	}

	public Button getView_cart_btn() {
		return view_cart_btn;
	}

	public Button getView_orders_btn() {
		return view_orders_btn;
	}

	public TextField getSearch__books_field() {
		return search__books_field;
	}

	public Label getWindow_label() {
		return window_label;
	}

	public TextArea getInventory_table() {
		return inventory_table;
	}

	public Button getView_more_btn() {
		return view_more_btn;
	}



	

	
	





	
	
}
