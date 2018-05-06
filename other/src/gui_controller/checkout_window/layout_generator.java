package gui_controller.checkout_window;


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
		
		HBox nav_bar = new HBox();
		nav_bar.getChildren().addAll(gui_elements.getBack_btn(), gui_elements.getWindow_label());
		nav_bar.setPadding(new Insets(35,0,0,0)); /* up, right, down, left */
		nav_bar.setSpacing(150);
		//nav_bar.setStyle("-fx-background-color: #eae7d7;");
		
		/* Recipient Info */
		//gui_elements.getin
		
		
		int att_spacing = 5;
		Font header_font = Font.font("Verdana", FontWeight.BOLD, 15);
		gui_elements.getRecipient_info_label().setFont(header_font);
		
		VBox tmp1 = new VBox();
		tmp1.setSpacing(att_spacing);
		tmp1.getChildren().addAll(gui_elements.getCustomer_name_label(), gui_elements.getCustomer_name_value_field());
		gui_elements.getCustomer_name_value_field().setDisable(true);
		
		VBox tmp2 = new VBox();
		tmp2.setSpacing(att_spacing);
		tmp2.getChildren().addAll(gui_elements.getCustomer_phone_label(), gui_elements.getCustomer_phone_value_field());
		gui_elements.getCustomer_phone_value_field().setDisable(true);
		
		VBox tmp3 = new VBox();
		tmp3.setSpacing(att_spacing);
		tmp3.getChildren().addAll(gui_elements.getCustomer_address_label(), gui_elements.getCustomer_address_value_field());
		gui_elements.getCustomer_address_value_field().setDisable(true);
		
		VBox recipient_info = new VBox();
		//recipient_info.setPadding(new Insets(50,0,50,0));
		recipient_info.getChildren().addAll(gui_elements.getRecipient_info_label(), tmp1, tmp2, tmp3);
		recipient_info.setSpacing(10);

		
		/* Card No */
		gui_elements.getCard_info_label().setFont(header_font);
		
		VBox tmp4 = new VBox();
		tmp4.setSpacing(att_spacing);
		tmp4.getChildren().addAll(gui_elements.getCard_no_label(), gui_elements.getCard_no_input_field());
		
		VBox tmp5 = new VBox();
		tmp5.setSpacing(att_spacing);
		tmp5.getChildren().addAll(gui_elements.getExpire_date_label(), gui_elements.getExpire_date_input_field());
		
		VBox card_info = new VBox();
		//card_info.setPadding(new Insets(50,0,50,0));
		card_info.getChildren().addAll(gui_elements.getCard_info_label(), tmp4, tmp5);
		card_info.setSpacing(10);
		
		/* Info container */
		VBox info_container = new VBox();
		info_container.getChildren().addAll(recipient_info, card_info, gui_elements.getPlace_order_btn());
		info_container.setPadding(new Insets(50,0,0,0));
		info_container.setSpacing(25);
		
		/* Overall window */
		layout.setTop(nav_bar);
		//layout.setLeft();
		layout.setCenter(info_container);
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
