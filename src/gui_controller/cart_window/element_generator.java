package gui_controller.cart_window;



import java.io.FileNotFoundException;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class element_generator {

	/************************************************/
	/* ATTRIBUTES */
	/************************************************/
	
	/* Navigation Bar */
	/**********************************/
	private Button back_btn;
	private Label window_label;
	private Button checkout_btn;
	
	/* Shopping Cart Table */
	/**********************************/
	private TextArea cart_table;
	
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
		back_btn = new Button("< Back");
		window_label = new Label("Shopping Cart");
		checkout_btn = new Button("Checkout");
		
		/* Shopping Cart Table */
		/**********************************/
		cart_table = new TextArea();
		
		/* Back-end Engine */
		/**********************************/
		
		
	}
	
	
	/************************************************/
	/* GETTERS */
	/************************************************/
	public Button getBack_btn() {
		return back_btn;
	}

	public Label getWindow_label() {
		return window_label;
	}
	
	public Button getCheckout_btn() {
		return checkout_btn;
	}


	public TextArea getCart_table() {
		return cart_table;
	}

	

	
	






	
	
}

