package gui_controller.signin_window;

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
		/* back button */
		gui_elements.getBack_btn().setOnMouseClicked(e->{
			gui_controller.update_stage(gui_controller.getHome_scene());
		});
		
		/* sign in button */
		gui_elements.getSign_in_btn().setOnMouseClicked(e->{
			gui_controller.update_stage(gui_controller.getHome_scene());
		});
		
		/* sign up button */
		gui_elements.getSign_up_btn().setOnMouseClicked(e->{
			gui_controller.update_stage(gui_controller.getSignup_scene());
		});

	}	
	
	/************************************************/
	/* HELPER METHODS */
	/************************************************/
	

	
	
}
