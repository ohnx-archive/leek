package ca.masonx.leek.core.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
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
	 * The panel that is getting drawn to.
	 */
	private Panel mainPanel;

	/**
	 * Initialize the GUI.
	 * 
	 * @param title	The title of the window
	 * @param width	The width of the window
	 * @param height	The height of the window
	 */
	public void initGUI(String title) {
		mainFrame = new Frame(title);
		/* Force game to autoquit */
		//TODO: Do not make force quit game
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}
		});
		mainPanel = new Panel();
		mainFrame.add(mainPanel, BorderLayout.CENTER);
	    mainFrame.setVisible(true);
	    mainFrame.pack();
	}
	
	/**
	 * Set the panel size.
	 * 
	 * @param width		The width of the panel
	 * @param height	The height of the panel
	 */
	public void setPanelSize(int width, int height) {
		mainPanel.setPreferredSize(new Dimension(width, height));
		mainPanel.setSize(new Dimension(width, height));
	}
	
	/**
	 * Set the frame size.
	 * 
	 * @param width		The width of the frame
	 * @param height	The height of the frame
	 */
	public void setFrameSize(int width, int height) {
		mainFrame.setSize(new Dimension(width, height));
		//mainFrame.setResizable(false);
	}
	
	/**
	 * Get the dimensions of the panel.
	 * 
	 * @return	The Dimension of the panel
	 */
	public Dimension getPanelDimensions() {
		return mainPanel.getSize();
	}
	
	/**
	 * Get the panel.
	 * 
	 * @return	The Panel
	 */
	public Panel getPanel() {
		return mainPanel;
	}
	
	/**
	 * Get the graphics context to draw on the screen.
	 * @return	The graphics context.
	 */
	public Graphics getGraphics() {
		return mainPanel.getGraphics();
	}
}
