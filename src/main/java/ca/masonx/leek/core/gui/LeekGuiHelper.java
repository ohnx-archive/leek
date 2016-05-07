package ca.masonx.leek.core.gui;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Leek GUI Helper.
 * 
 * Initializes AWT and gets contexts to draw on and whatnot.
 */
public class LeekGuiHelper {
	/**
	 * The main frame/window that is getting drawn to.
	 */
	private Frame mainFrame;

	/**
	 * Initialize the GUI.
	 * 
	 * @param title	The title of the window
	 * @param width	The width of the window
	 * @param height	The height of the window
	 */
	public void initGUI(String title, int width, int height) {
		mainFrame = new Frame(title);
	    mainFrame.setSize(width, height);
		mainFrame.setLayout(new GridLayout(1, 1));
		/* Force game to autoquit */
		//TODO: Do not make force quit game
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}
		}); 
	    mainFrame.setVisible(true);  
	}
}
