package gui_controller;


import javafx.application.Application;
import javafx.stage.Stage;



public class MAIN extends Application {
	
	/************************************************/
	/* ATTRIBUTES */
	/************************************************/
	window_controller gui_controller;
	Stage stage;

	
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
		gui_controller = new window_controller(stage);
		gui_controller.initialize_windows();
		gui_controller.show_stage();
		
	}

	
}


