package gui_controller.signup_window;

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
		/* cancel sign up button */
		gui_elements.getCancel_btn().setOnMouseClicked(e->{
			gui_controller.update_stage(gui_controller.getSignin_scene());
		});
		
		/* create account button */
		gui_elements.getCreate_account_btn().setOnMouseClicked(e->{
			gui_controller.update_stage(gui_controller.getHome_scene());
		});

	}	
	
	/************************************************/
	/* HELPER METHODS */
	/************************************************/
	

	
	
}
