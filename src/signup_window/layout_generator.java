package signup_window;


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
		int btn_width = 75;
		int btn_height = 35;
		HBox nav_bar = new HBox();
		gui_elements.getCancel_btn().setPrefSize(btn_width, btn_height);
		gui_elements.getWindow_label().setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		nav_bar.getChildren().addAll(gui_elements.getCancel_btn(), gui_elements.getWindow_label());
		nav_bar.setPadding(new Insets(50,0,0,0)); /* up, right, down, left */
		nav_bar.setSpacing(100);
		//nav_bar.setStyle("-fx-background-color: #eae7d7;");
		
		/* Sign in Fields */
		
		/* input fields */
		int field_width = 150;
		int field_height = 32;
		gui_elements.getUser_name_input_area().setPrefSize(field_width, field_height);
		gui_elements.getPassword_input_area().setPrefSize(field_width, field_height);
		gui_elements.getFirst_name_input_area().setPrefSize(field_width, field_height);
		gui_elements.getLast_name_input_area().setPrefSize(field_width, field_height);
		gui_elements.getEmail_input_area().setPrefSize(field_width, field_height);
		gui_elements.getPhone_input_area().setPrefSize(field_width, field_height);
		gui_elements.getAddress_input_area().setPrefSize(field_width, field_height);
		
		/* field labels */
		Font tmp = Font.font("Verdana", FontWeight.NORMAL, 15);
		gui_elements.getUser_name_label().setFont(tmp);
		gui_elements.getPassword_label().setFont(tmp);
		gui_elements.getFirst_name_label().setFont(tmp);
		gui_elements.getLast_name_label().setFont(tmp);
		gui_elements.getEmail_label().setFont(tmp);
		gui_elements.getPhone_label().setFont(tmp);
		gui_elements.getAddress_label().setFont(tmp);
		
		/* user name */
		int att_spacing = 5;
		VBox tmp1 = new VBox();
		tmp1.setSpacing(att_spacing);
		tmp1.getChildren().addAll(gui_elements.getUser_name_label(), gui_elements.getUser_name_input_area());
		
		/* password */
		VBox tmp2 = new VBox();
		tmp2.setSpacing(att_spacing);
		tmp2.getChildren().addAll(gui_elements.getPassword_label(), gui_elements.getPassword_input_area());
		
		/* first name */
		VBox tmp3 = new VBox();
		tmp3.setSpacing(att_spacing);
		tmp3.getChildren().addAll(gui_elements.getFirst_name_label(), gui_elements.getFirst_name_input_area());
		
		/* last name */
		VBox tmp4 = new VBox();
		tmp4.setSpacing(att_spacing);
		tmp4.getChildren().addAll(gui_elements.getLast_name_label(), gui_elements.getLast_name_input_area());
		
		/* email */
		VBox tmp5 = new VBox();
		tmp5.setSpacing(att_spacing);
		tmp5.getChildren().addAll(gui_elements.getEmail_label(), gui_elements.getEmail_input_area());
		
		/* phone */
		VBox tmp6 = new VBox();
		tmp6.setSpacing(att_spacing);
		tmp6.getChildren().addAll(gui_elements.getPhone_label(), gui_elements.getPhone_input_area());
		
		/* shipping address */
		VBox tmp7 = new VBox();
		tmp7.setSpacing(att_spacing);
		tmp7.getChildren().addAll(gui_elements.getAddress_label(), gui_elements.getAddress_input_area());
		
		
		/* sign buttons */
		HBox tmp8 = new HBox();
		gui_elements.getCreate_account_btn().setPrefSize(btn_width, btn_height);
		tmp8.setPadding(new Insets(15,0,0,0));
		tmp8.getChildren().add(gui_elements.getCreate_account_btn());
		
		VBox sign_in_fields = new VBox();
		sign_in_fields.getChildren().addAll(tmp1, tmp2, tmp3, tmp4, tmp5, tmp6, tmp7, tmp8);
		sign_in_fields.setPadding(new Insets(30,0,0,0));
		sign_in_fields.setSpacing(7);

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
