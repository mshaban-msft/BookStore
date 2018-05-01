package signin_window;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class layout_generator {

	/************************************************/
	/* ATRIBUTES */
	/************************************************/
	private element_generator gui_elements;
	private BorderPane layout;
		
		
	/************************************************/
	/* CONSTRUCTOR */
	/************************************************/
	public
	layout_generator(element_generator gui_elements)
	{
		this.gui_elements = gui_elements;
		layout = new BorderPane();
	}
		

	/************************************************/
	/* INTERFACE METHODS */
	/************************************************/
	public void
	build_layout()
	{
		
		/* Navigation Bar */
		HBox nav_bar = new HBox();
		gui_elements.getBack_btn().setPrefSize(74, 35);
		gui_elements.getWindow_label().setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		nav_bar.getChildren().addAll(gui_elements.getBack_btn(), gui_elements.getWindow_label());
		nav_bar.setPadding(new Insets(50,0,0,0)); /* up, right, down, left */
		nav_bar.setSpacing(150);
		//nav_bar.setStyle("-fx-background-color: #eae7d7;");
		
		/* Sign in Fields */
		
		/* user name */
		VBox tmp1 = new VBox();
		gui_elements.getUser_name_label().setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
		gui_elements.getUser_name_input_area().setPrefSize(150, 50);
		tmp1.setSpacing(10);
		tmp1.getChildren().addAll(gui_elements.getUser_name_label(), gui_elements.getUser_name_input_area());
		
		/* password */
		VBox tmp2 = new VBox();
		gui_elements.getPassword_label().setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
		gui_elements.getPassword_input_area().setPrefSize(150, 50);
		tmp2.setSpacing(10);
		tmp2.getChildren().addAll(gui_elements.getPassword_label(), gui_elements.getPassword_input_area());
		
		/* sign buttons */
		HBox tmp3 = new HBox();
		gui_elements.getSign_in_btn().setPrefSize(74, 35);
		gui_elements.getSign_up_btn().setPrefSize(74, 35);
		tmp3.setSpacing(20);
		tmp3.setPadding(new Insets(15,0,50,0));
		tmp3.getChildren().addAll(gui_elements.getSign_in_btn(), gui_elements.getSign_up_btn());
		
		VBox sign_in_fields = new VBox();
		sign_in_fields.getChildren().addAll(tmp1, tmp2, tmp3);
		sign_in_fields.setPadding(new Insets(50,0,50,0));
		sign_in_fields.setSpacing(30);

		/* Overall window */
		layout.setTop(nav_bar);
		//layout.setLeft();
		layout.setCenter(sign_in_fields);
		//layout.setRight();
		//layout.setPrefSize(900, 550);
		layout.setPadding(new Insets(0,200,0,200));

	}
	
	public Pane
	get_layout()
	{
		return layout;
	}
	
	
	
	
	
}
