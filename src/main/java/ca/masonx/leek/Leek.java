package ca.masonx.leek;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

import ca.masonx.leek.core.events.EventDelegate;
import ca.masonx.leek.core.events.LeekEvent;
import ca.masonx.leek.core.gameElement.Level;
import ca.masonx.leek.core.gui.LeekGuiHelper;

/**
 * Leek main class.
 * Programs that use Leek interface with this class (mostly).
 */
public class Leek extends LeekEvent {
	/**
	 * GUI helper for Leek
	 */
	protected LeekGuiHelper guiHelper;
	
	/**
	 * Event Delegator
	 */
	protected EventDelegate ed;
	
	/**
	 * The current level that is being displayed.
	 */
	protected Level currLevel;
	
	/**
	 * Initialization functions for Leek.
	 * 
	 * @param windowName	The name of the window.
	 * @param width			The width of the window.
	 * @param height		The height of the window.
	 */
	public void init(String windowName) {
		guiHelper.initGUI(windowName);
	}
	
	/**
	 * Leek instantiation
	 */
	public Leek() {
		guiHelper = new LeekGuiHelper();
	}
	
	public boolean enterMainLoop() {
		return mainLoop(30);
	}
	
	@SuppressWarnings("unused")
	protected boolean mainLoop(int targetFPS) {
		// Variables for use with updating stuff
		double dt = 1.0 / targetFPS * 1000.0;
		double currentTime;
		double newTime;
		double frameTime;
		double deltaTime;
		
		// Double buffering setup
		Graphics g = guiHelper.getGraphics();
		Dimension d = guiHelper.getPanelDimensions();
		Panel p = guiHelper.getPanel();
		int bufh = d.height;
		int bufw = d.width;
		
		// Create the back buffer
		Image bufferImg = p.createImage(bufh, bufw);
		Graphics buffer = bufferImg.getGraphics();

		currentTime = System.currentTimeMillis();

		// loop
		while (true) {
			// get the delta times and whatnot
			newTime = System.currentTimeMillis();
			frameTime = newTime - currentTime;
			currentTime = newTime;
			
			// break down the time chunks into blocks and call update each block
			while (frameTime > 0.0) {
				deltaTime = Math.min(frameTime, dt);
				currLevel.update(deltaTime);
				frameTime -= deltaTime;
			}
			
			// render the level to the backbuffer
		    currLevel.render(buffer);
		    
		    // blit backbuffer
		    g.drawImage(bufferImg, 0, 0, null);
		    
		    // clear the backbuffer
		    buffer.setColor(Color.RED);
		    buffer.fillRect(0, 0, bufw, bufh);
		    
		    if (false)
		    	break;
		}
		return false;
	}
	
	public void changeLevel(Level l) {
		//TODO: Transition nicely to the next level
		currLevel = l;
		guiHelper.setPanelSize(l.width, l.height);
		
	}
}
