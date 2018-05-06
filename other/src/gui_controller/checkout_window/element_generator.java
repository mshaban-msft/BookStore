package gui_controller.checkout_window;


import java.io.FileNotFoundException;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class element_generator {

	/************************************************/
	/* ATTRIBUTES */
	/************************************************/
	
	/* Navigation Bar */
	/**********************************/
	private Button back_btn;
	private Label window_label;
	
	/* Recipient Info */
	/**********************************/
	private Label recipient_info_label;
	private Label customer_name_label;
	private TextField customer_name_value_field;
	private Label customer_phone_label;
	private TextField customer_phone_value_field;
	private Label customer_address_label;
	private TextField customer_address_value_field;
	
	/* Card Info */
	/**********************************/
	private Label card_info_label;
	private Label card_no_label;
	private TextField card_no_input_field;
	private Label expire_date_label;
	private TextField expire_date_input_field;
	
	private Button place_order_btn;
	
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
		window_label = new Label("Checkout");
		
		/* Recipient Info */
		/**********************************/
		recipient_info_label = new Label("Recipient Info");
		customer_name_label = new Label("Name");
		customer_name_value_field = new TextField("Mohamed Shaapan");
		customer_phone_label = new Label("Phone");
		customer_phone_value_field = new TextField("011123456678");
		customer_address_label = new Label("Address");
		customer_address_value_field = new TextField("Alexandria, Egypt");
		
		/* Card Info */
		/**********************************/
		card_info_label = new Label("Credit Card");
		card_no_label = new Label("Card No");
		card_no_input_field = new TextField();
		expire_date_label = new Label("Expire Date");
		expire_date_input_field = new TextField();
		
		place_order_btn = new Button("Place Order");
		
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

	public Label getRecipient_info_label() {
		return recipient_info_label;
	}

	public Label getCustomer_name_label() {
		return customer_name_label;
	}

	public TextField getCustomer_name_value_field() {
		return customer_name_value_field;
	}

	public Label getCustomer_phone_label() {
		return customer_phone_label;
	}

	public TextField getCustomer_phone_value_field() {
		return customer_phone_value_field;
	}

	public Label getCustomer_address_label() {
		return customer_address_label;
	}

	public TextField getCustomer_address_value_field() {
		return customer_address_value_field;
	}

	public Label getCard_info_label() {
		return card_info_label;
	}

	public Label getCard_no_label() {
		return card_no_label;
	}

	public TextField getCard_no_input_field() {
		return card_no_input_field;
	}

	public Label getExpire_date_label() {
		return expire_date_label;
	}

	public TextField getExpire_date_input_field() {
		return expire_date_input_field;
	}

	public Button getPlace_order_btn() {
		return place_order_btn;
	}
	
	
	


	
	






	
	
}

