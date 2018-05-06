package gui_controller.account_window;


import gui_controller.window_controller;

public class action_listeners_generator {

	/************************************************/
	/* ATTRIBUTES */
	/************************************************/
	private element_generator gui_elements;
	private window_controller gui_controller;
	private layout_generator gui_layout;

	
	/************************************************/
	/* CONSTRUCTOR */
	/************************************************/
	public
	action_listeners_generator(element_generator gui_elements, layout_generator gui_layout, window_controller gui_controller)
	{
		this.gui_elements = gui_elements;
		this.gui_layout = gui_layout;
		this.gui_controller = gui_controller;
	}
	

	/************************************************/
	/* INTERFACE METHODS */
	/************************************************/
	public void
	setup_actions()
	{
		/* sign in up button */
		gui_elements.getBack_btn().setOnMouseClicked(e->{
			gui_controller.update_stage(gui_controller.getHome_scene());
		});
		
		/* view account button */
		gui_elements.getEdit_done_btn().setOnMouseClicked(e->{
			if(gui_elements.getEdit_done_btn().getText().equalsIgnoreCase("edit"))
			{
				gui_layout.set_inputfields_disable(false);
				gui_elements.getEdit_done_btn().setText("Save");
			}
			else
			{
				gui_layout.set_inputfields_disable(true);
				gui_elements.getEdit_done_btn().setText("Edit");
			}
		});

	}	
	
	/************************************************/
	/* HELPER METHODS */
	/************************************************/
	

	
	
}
