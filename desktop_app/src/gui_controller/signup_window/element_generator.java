package gui_controller.signup_window;


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
	private Button cancel_btn;
	private Label window_label;
	
	/* Sign Up Fields */
	/**********************************/
	private Label user_name_label;
	private TextField user_name_input_area;
	
	private Label password_label;
	private TextField password_input_area;
	
	private Label first_name_label;
	private TextField first_name_input_area;
	
	private Label last_name_label;
	private TextField last_name_input_area;
	
	private Label email_label;
	private TextField email_input_area;
	
	private Label phone_label;
	private TextField phone_input_area;
	
	private Label address_label;
	private TextField address_input_area;
	
	private Button create_account_btn;
	
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
		cancel_btn = new Button("Cancel");
		window_label = new Label("New Account");
		
		/* Sign up Fields */
		/**********************************/
		user_name_label = new Label("UserName");
		user_name_input_area = new TextField();
		
		password_label = new Label("Password");
		password_input_area = new TextField();
		
		first_name_label = new Label("FirstName");
		first_name_input_area = new TextField();
		
		last_name_label = new Label("Last Name");
		last_name_input_area = new TextField();
		
		email_label = new Label("Email");
		email_input_area = new TextField();
		
		phone_label = new Label("Phone");
		phone_input_area = new TextField();
		
		address_label = new Label("Shipping Address");
		address_input_area = new TextField();
		
		create_account_btn = new Button("Create");
		
		/* Back-end Engine */
		/**********************************/
		
		
	}
	
	
	/************************************************/
	/* GETTERS */
	/************************************************/
	public Button getCancel_btn() {
		return cancel_btn;
	}

	public Label getWindow_label() {
		return window_label;
	}

	public Label getUser_name_label() {
		return user_name_label;
	}

	public TextField getUser_name_input_area() {
		return user_name_input_area;
	}

	public Label getPassword_label() {
		return password_label;
	}

	public TextField getPassword_input_area() {
		return password_input_area;
	}

	public Label getFirst_name_label() {
		return first_name_label;
	}

	public TextField getFirst_name_input_area() {
		return first_name_input_area;
	}

	public Label getLast_name_label() {
		return last_name_label;
	}

	public TextField getLast_name_input_area() {
		return last_name_input_area;
	}

	public Label getEmail_label() {
		return email_label;
	}

	public TextField getEmail_input_area() {
		return email_input_area;
	}

	public Label getPhone_label() {
		return phone_label;
	}

	public TextField getPhone_input_area() {
		return phone_input_area;
	}

	public Label getAddress_label() {
		return address_label;
	}

	public TextField getAddress_input_area() {
		return address_input_area;
	}

	public Button getCreate_account_btn() {
		return create_account_btn;
	}

	
	






	
	
}
