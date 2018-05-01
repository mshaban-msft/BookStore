package main_body;


import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import signin_window.signin_controller;
import signup_window.signup_controller;



public class MAIN extends Application {
	
	/************************************************/
	/* ATTRIBUTES */
	/************************************************/
	signin_controller signin_window;
	signup_controller signup_window;
	
	Stage stage;
	Scene signin_scene;
	Scene signup_scene;
	
	int win_width = 1000;
	int win_height = 650;
	
	/************************************************/
	/* RUN APPLICATION */
	/************************************************/
	public static void
	main(String[] args)
	{
		launch(args);
	}

	
	public void
	start(Stage primaryStage) throws Exception
	{
		stage = primaryStage;
		
		/* initialize windows */
		initialize_windows();
		set_nav_actions();
		
		/* set initial scene */
		update_stage(signup_scene);
		
		/*Scene scene=new Scene(layout, 1000, 650);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Chess Game");
		primaryStage.setMinHeight(550);
		primaryStage.setMinWidth(900);
		primaryStage.show();*/
	}
	
	
	/************************************************/
	/* ATTRIBUTES */
	/************************************************/
	public void
	initialize_windows() throws FileNotFoundException
	{
		signin_window=new signin_controller();
		signin_window.initialize_window();
		signin_scene = new Scene(signin_window.get_window(), win_width, win_height);
		
		signup_window=new signup_controller();
		signup_window.initialize_window();
		signup_scene = new Scene(signup_window.get_window(), win_width, win_height);
	}
	
	
	/************************************************/
	/* ATTRIBUTES */
	/************************************************/
	public void
	set_nav_actions()
	{
		signin_window.get_nav_btn().setOnMouseClicked(e->{
			update_stage(signup_scene);
		});
		
		signup_window.get_nav_btn().setOnMouseClicked(e->{
			update_stage(signin_scene);
		});
	}
	

	/************************************************/
	/* ATTRIBUTES */
	/************************************************/
	public void
	update_stage(Scene scene)
	{
		stage.setScene(scene);
		stage.show();
	}
	
}


