package main_body;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sign_in_window.sign_in_controller;



public class MAIN extends Application {
	
	/************************************************/
	/* ATTRIBUTES */
	/************************************************/
	private sign_in_controller signin_window;
	private Pane layout;
	
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
		
		/* 01_Initialize Application */
		signin_window=new sign_in_controller();
		signin_window.initialize_window();
		layout = signin_window.get_window();
		
		/* 02_show final window */
		Scene scene=new Scene(layout, 1000, 650);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Chess Game");
		primaryStage.setMinHeight(550);
		primaryStage.setMinWidth(900);
		primaryStage.show();
	}

	
}


