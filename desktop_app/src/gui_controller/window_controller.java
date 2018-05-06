package gui_controller;




import java.io.FileNotFoundException;

import gui_controller.account_window.account_controller;
import gui_controller.cart_window.cart_controller;
import gui_controller.checkout_window.checkout_controller;
import gui_controller.home_window.home_controller;
import gui_controller.signin_window.signin_controller;
import gui_controller.signup_window.signup_controller;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class window_controller {
	
	/************************************************/
	/* ATTRIBUTES */
	/************************************************/
	private home_controller home_window;
	private signin_controller signin_window;
	private signup_controller signup_window;
	private account_controller account_window;
	private cart_controller cart_window;
	private checkout_controller checkout_window;
	
	private Stage stage;
	private Scene home_scene;
	private Scene signin_scene;
	private Scene signup_scene;
	private Scene account_scene;
	private Scene cart_scene;
	private Scene checkout_scene;
	
	private int win_width = 1000;
	private int win_height = 660;
	
	/************************************************/
	/* CONSTRUCTOR */
	/************************************************/
	public
	window_controller(Stage stage)
	{
		this.stage=stage;
	}

	/************************************************/
	/* INTERFACE METHODS */
	/************************************************/
	public void
	initialize_windows() throws FileNotFoundException
	{
		home_window = new home_controller(this);
		home_window.initialize_window();
		home_scene = new Scene(home_window.get_window(), win_width, win_height);
		
		signin_window = new signin_controller(this);
		signin_window.initialize_window();
		signin_scene = new Scene(signin_window.get_window(), win_width, win_height);
		
		signup_window = new signup_controller(this);
		signup_window.initialize_window();
		signup_scene = new Scene(signup_window.get_window(), win_width, win_height);
		
		account_window = new account_controller(this);
		account_window.initialize_window();
		account_scene = new Scene(account_window.get_window(), win_width, win_height);
		
		cart_window = new cart_controller(this);
		cart_window.initialize_window();
		cart_scene = new Scene(cart_window.get_window(), win_width, win_height);
		
		checkout_window = new checkout_controller(this);
		checkout_window.initialize_window();
		checkout_scene = new Scene(checkout_window.get_window(), win_width, win_height);
	}
	
	public void
	show_stage()
	{
		stage.setResizable(false);
		stage.setTitle("Barnes & Noble");
		update_stage(home_scene);
	}
	
	public void
	update_stage(Scene scene)
	{
		stage.setScene(scene);
		stage.show();
	}

	
	/************************************************/
	/* GETTERS */
	/************************************************/
	public Scene getHome_scene() {
		return home_scene;
	}

	public Scene getSignin_scene() {
		return signin_scene;
	}

	public Scene getSignup_scene() {
		return signup_scene;
	}

	public Scene getAccount_scene() {
		return account_scene;
	}

	public Scene getCart_scene() {
		return cart_scene;
	}

	public Scene getCheckout_scene() {
		return checkout_scene;
	}


	
	
}


