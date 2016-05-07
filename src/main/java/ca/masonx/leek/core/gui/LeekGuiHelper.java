package ca.masonx.leek.core.gui;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LeekGuiHelper {
	private Frame mainFrame;
	public void initGUI(String title, int width, int height) {
		mainFrame = new Frame(title);
	    mainFrame.setSize(width, height);
		mainFrame.setLayout(new GridLayout(1, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}        
		}); 
	    mainFrame.setVisible(true);  
	}
}
