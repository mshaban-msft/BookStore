package gui_controller.account_window;



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
		Font title_font = Font.font("Verdana", FontWeight.BOLD, 25);
		gui_elements.getBack_btn().setPrefSize(btn_width, btn_height);
		gui_elements.getWindow_label().setFont(title_font);
		gui_elements.getEdit_done_btn().setPrefSize(btn_width, btn_height);
		
		HBox nav_bar = new HBox();
		nav_bar.getChildren().addAll(gui_elements.getBack_btn(), gui_elements.getWindow_label(), gui_elements.getEdit_done_btn());
		nav_bar.setPadding(new Insets(35,0,0,0)); /* up, right, down, left */
		nav_bar.setSpacing(140);
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
		set_inputfields_disable(true);
		
		/* field labels */
		Font tmp = Font.font("Verdana", FontWeight.NORMAL, 13);
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
		
		/* account info fields */
		VBox sign_in_fields = new VBox();
		sign_in_fields.getChildren().addAll(tmp1, tmp2, tmp3, tmp4, tmp5, tmp6, tmp7);
		sign_in_fields.setPadding(new Insets(30,0,0,0));
		sign_in_fields.setSpacing(10);

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
	
	public void
	set_inputfields_disable(boolean value)
	{
		gui_elements.getUser_name_input_area().setDisable(value);
		gui_elements.getPassword_input_area().setDisable(value);
		gui_elements.getFirst_name_input_area().setDisable(value);
		gui_elements.getLast_name_input_area().setDisable(value);
		gui_elements.getEmail_input_area().setDisable(value);
		gui_elements.getPhone_input_area().setDisable(value);
		gui_elements.getAddress_input_area().setDisable(value);
	}
	
	
	
	
	
}
