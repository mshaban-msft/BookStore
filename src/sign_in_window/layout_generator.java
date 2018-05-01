package sign_in_window;

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
		nav_bar.setPadding(new Insets(50,50,50,100)); /* up, right, down, left */
		nav_bar.setSpacing(250);
		//nav_bar.setStyle("-fx-background-color: #eae7d7;");
		
		/* Sign in Fields */
		VBox sign_in_fields = new VBox();
		gui_elements.getUser_name_field().setPrefSize(150, 50);
		gui_elements.getPassword_fiels().setPrefSize(150, 50);
		gui_elements.getSign_in_btn().setPrefSize(74, 35);
		gui_elements.getSign_up_btn().setPrefSize(74, 35);
		HBox sign_btns_container = new HBox();
		sign_btns_container.getChildren().addAll(gui_elements.getSign_in_btn(), gui_elements.getSign_up_btn());
		sign_in_fields.getChildren().addAll(gui_elements.getUser_name_field(), gui_elements.getPassword_fiels());
		sign_btns_container.setSpacing(20);
		sign_in_fields.getChildren().add(sign_btns_container);
		sign_in_fields.setPadding(new Insets(10,100,50,100));
		sign_in_fields.setSpacing(20);

		/* Overall window */
		layout.setTop(nav_bar);
		//layout.setLeft();
		layout.setCenter(sign_in_fields);
		//layout.setRight();
		//layout.setPrefSize(900, 550);

	}
	
	public Pane
	get_layout()
	{
		return layout;
	}
	
	
	
	
	
}
