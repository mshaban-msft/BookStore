package gui_controller.home_window;

import gui_controller.window_controller;

public class action_listeners_generator {

	/************************************************/
	/* ATTRIBUTES */
	/************************************************/
	private element_generator gui_elements;
	private window_controller gui_controller;

	
	/************************************************/
	/* CONSTRUCTOR */
	/************************************************/
	public
	action_listeners_generator(element_generator gui_elements, window_controller gui_controller)
	{
		this.gui_elements = gui_elements;
		this.gui_controller = gui_controller;
	}
	

	/************************************************/
	/* INTERFACE METHODS */
	/************************************************/
	public void
	setup_actions()
	{
		/* sign in up button */
		gui_elements.getSign_in_out_btn().setOnMouseClicked(e->{
			gui_controller.update_stage(gui_controller.getSignin_scene());
		});
		
		/* view account button */
		gui_elements.getView_account_btn().setOnMouseClicked(e->{
			gui_controller.update_stage(gui_controller.getAccount_scene());
		});
		
		/* view cart button */
		gui_elements.getView_cart_btn().setOnMouseClicked(e->{
			gui_controller.update_stage(gui_controller.getCart_scene());
		});
		
		/* view orders button */
		gui_elements.getView_orders_btn().setOnMouseClicked(e->{

		});
		
		/* view more table elements button */
		gui_elements.getView_more_btn().setOnMouseClicked(e->{

		});

	}	
	
	/************************************************/
	/* HELPER METHODS */
	/************************************************/
	

	
	
}
