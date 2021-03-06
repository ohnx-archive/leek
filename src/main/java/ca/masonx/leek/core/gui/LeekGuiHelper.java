package ca.masonx.leek.core.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Leek GUI Helper.
 * 
 * Initializes AWT and gets contexts to draw on and whatnot.
 * 
 * Recommended internal use only.
 */
public class LeekGuiHelper {
	/**
	 * The main frame/window that contains the panel.
	 */
	private Frame mainFrame;
	
	/**
	 * The panel that is getting drawn to.
	 */
	private Panel mainPanel;

	/**
	 * Initialize the GUI.
	 * 
	 * @param title	The title of the window.
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
		
		// create the main panel
		mainPanel = new Panel();
		
		// add it to the frame
		mainFrame.add(mainPanel, BorderLayout.CENTER);
	    
	    // debug
	    mainFrame.setBackground(Color.BLACK);
	    mainPanel.setBackground(Color.BLACK);
	    
	    mainFrame.setResizable(false);
	    
	    // give the focus to the panel automatically
	    // so that the user doesn't have to manually click on it
	    mainPanel.setFocusable(true);
	    mainPanel.requestFocus();
	    
	    // show the main frame
	    mainFrame.setVisible(true);
	}
	
	public void setFrameIcon(Image frameIcon) {
		mainFrame.setIconImage(frameIcon);
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
		mainFrame.pack();
	}
	
	/**
	 * Center the frame.
	 */
	public void centerFrame() {
		mainFrame.setLocationRelativeTo(null);
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
	 * Get the frame.
	 * 
	 * @return	The Frame
	 */
	public Frame getFrame() {
		return mainFrame;
	}
	
	/**
	 * Get the graphics context to draw on the screen.
	 * @return	The graphics context.
	 */
	public Graphics getGraphics() {
		return mainPanel.getGraphics();
	}
}
