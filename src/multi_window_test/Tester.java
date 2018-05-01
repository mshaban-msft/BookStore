package multi_window_test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tester extends Application {
	

	VBox layout1;
	VBox layout2;
	Stage stage;
	
	int window_width = 600;
	int window_height = 400;
	
	Scene scene1;
	Scene scene2;
	
	
	//02_RUN APPLICATION
	//*************************************************************
	public static void
	main(String[] args)
	{
		launch(args);
	}

	//*************************************************************
	public void
	start(Stage primaryStage) throws Exception 
	{
		stage = primaryStage;
		
		layout1 = new VBox();
		Button bt1 = new Button("Go Window 2");
		layout1.getChildren().add(bt1);
		layout1.setPadding(new Insets(50,50,50,50));
		bt1.setOnMouseClicked(e ->{
			/*******************************************/
			update_stage(scene2);
		});
		scene1=new Scene(layout1, window_width, window_height);
		
		layout2 = new VBox();
		layout2.setPadding(new Insets(200, 200, 200, 200));
		Button bt2 = new Button("Go Window 1");
		layout2.getChildren().add(bt2);
		bt2.setOnMouseClicked(e ->{
			/*******************************************/
			update_stage(scene1);
		});
		scene2=new Scene(layout2, window_width, window_height);
		
		
		/* 02_show final window */
		update_stage(scene1);
		/*Scene scene=new Scene(layout1, 600, 400);
		stage.setScene(scene);
		//stage.setResizable(false);
		//stage.setTitle("Chess Game");
		//stage.setMinHeight(550);
		//stage.setMinWidth(900);
		stage.show();*/
	}
	
	
	public void
	update_stage(Scene scene)
	{
		stage.setScene(scene);
		stage.show();
	}
	
	

	
}


