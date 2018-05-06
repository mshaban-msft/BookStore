package gui_controller.cart_window;




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
		gui_elements.getCheckout_btn().setPrefSize(100, btn_height);
		
		HBox nav_bar = new HBox();
		nav_bar.getChildren().addAll(gui_elements.getBack_btn(), gui_elements.getWindow_label(), gui_elements.getCheckout_btn());
		nav_bar.setPadding(new Insets(35,0,0,0)); /* up, right, down, left */
		nav_bar.setSpacing(110);
		//nav_bar.setStyle("-fx-background-color: #eae7d7;");
		
		/* Shopping Cart Table */
		int table_width = 500;
		int table_height = 300;
		gui_elements.getCart_table().setPrefSize(table_width, table_height);
		gui_elements.getCart_table().setEditable(false);
		
		VBox table_container = new VBox();
		table_container.setPadding(new Insets(50,0,50,0));
		table_container.getChildren().add(gui_elements.getCart_table());

		/* Overall window */
		layout.setTop(nav_bar);
		//layout.setLeft();
		layout.setCenter(table_container);
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
