package signin_window;


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
	
	/* Sign In Fields */
	/**********************************/
	private Label user_name_label;
	private TextField user_name_input_area;
	private Label password_label;
	private TextField password_input_area;
	private Button sign_in_btn;
	private Button sign_up_btn;
	
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
		window_label = new Label("SIGN IN");
		
		/* Sign In Fields */
		/**********************************/
		user_name_label = new Label("User Name");
		user_name_input_area = new TextField();
		password_label = new Label("Password");
		password_input_area = new TextField();
		sign_in_btn = new Button("Sign In");
		sign_up_btn = new Button("Sign Up");
		
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

	public Button getSign_in_btn() {
		return sign_in_btn;
	}

	public Button getSign_up_btn() {
		return sign_up_btn;
	}





	
	
}
