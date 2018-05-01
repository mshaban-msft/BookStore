package sign_in_window;


import java.io.FileNotFoundException;

import javafx.scene.layout.Pane;

public class sign_in_controller {
	
	/************************************************/
	/* ATTRIBUTES */
	/************************************************/
	private element_generator elements;
	private layout_generator layout;
	//private action_listeners_generator actionListeners;
	//private HotKeysInitializer hotKeys;
	
	
	/************************************************/
	/* CONSTRUCTOR */
	/************************************************/
	public
	sign_in_controller()
	{
		elements=new element_generator();
		layout=new layout_generator(elements);
		//actionListeners=new ActionListenersGenerator(elements);
		//hotKeys=new HotKeysInitializer(elements);
	}
	
	/************************************************/
	/* INTERFACE METHODS */
	/************************************************/
	public void
	initialize_window() throws FileNotFoundException
	{
		elements.generate_elements();
		layout.build_layout();
		//actionListeners.initialize();
		//hotKeys.initialize();
	}
	
	public Pane get_window()
	{
		return layout.get_layout();
	}
	
	
}
