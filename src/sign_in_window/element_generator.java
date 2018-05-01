package sign_in_window;


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
	private TextField user_name_field;
	private TextField password_fiels;
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
		user_name_field = new TextField("user name");
		password_fiels = new TextField("password");
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

	public TextField getUser_name_field() {
		return user_name_field;
	}

	public TextField getPassword_fiels() {
		return password_fiels;
	}

	public Button getSign_in_btn() {
		return sign_in_btn;
	}

	public Button getSign_up_btn() {
		return sign_up_btn;
	}


	
	
}
