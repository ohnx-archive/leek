package ca.masonx.leek;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

import ca.masonx.leek.core.events.CollisionEventManager;
import ca.masonx.leek.core.gui.LeekGuiHelper;
import ca.masonx.leek.core.physics.CollisionChecker;
import ca.masonx.leek.core.world.Level;

/**
 * Leek main class.
 * Programs that use Leek interface with this class (mostly).
 */
public class Leek {
	/**
	 * GUI helper for Leek
	 */
	protected LeekGuiHelper guiHelper;
	
	protected CollisionEventManager cem;
	
	/**
	 * The current level that is being displayed.
	 */
	protected Level currLevel;
	
	/**
	 * The location of the window on the screen.
	 */
	protected WindowLocation wl;
	
	/**
	 * Initialization functions for Leek.
	 * Uses only the window name, and the window
	 * will be in the top left.
	 * 
	 * @param windowName	The name of the window.
	 */
	public void init(String windowName) {
		guiHelper.initGUI(windowName);
		wl = WindowLocation.CENTER;
	}
	
	/**
	 * Initialization functions for Leek.
	 * Allows the user to specify where the window
	 * should be on the screen.
	 * 
	 * @param windowName	The name of the window.
	 * @param windowLocation	Where the window is on the screen.
	 */
	public void init(String windowName, WindowLocation windowLocation) {
		guiHelper.initGUI(windowName);
		wl = windowLocation;
	}
	
	/**
	 * Initialization functions for Leek.
	 * Allows the user to specify where the window
	 * should be on the screen.
	 * 
	 * @param windowName	The name of the window.
	 * @param windowLocation	Where the window is on the screen.
	 * @param windowIcon	The icon of the window.
	 */
	public void init(String windowName, WindowLocation windowLocation, Image windowIcon) {
		guiHelper.initGUI(windowName);
		wl = windowLocation;
		guiHelper.setFrameIcon(windowIcon);
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
		Image bufferImg = p.createImage(bufw, bufh);
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
				// get the smaller one between dt (aka max frame size vs remaining frame size)
				deltaTime = Math.min(frameTime, dt);
				// update the level based on that
				currLevel.update(deltaTime);
				// subtract frame time by the time that was updated
				frameTime -= deltaTime;
			}
			
			// Check collisions
			CollisionChecker.checkCollisions(currLevel);
			
			// render the level to the backbuffer
		    currLevel.render(buffer);
		    
		    // blit backbuffer
		    g.drawImage(bufferImg, 0, 0, null);
		    
		    // clear the backbuffer
		    buffer.setColor(Color.BLACK);
		    buffer.fillRect(0, 0, bufw, bufh);
		    
		    if (false)
		    	break;
		}
		return false;
	}
	
	/**
	 * Change the level.
	 * 
	 * @param l	Level to change to.
	 */
	public void changeLevel(Level l) {
		//TODO: Transition nicely to the next level
		if (currLevel != null) currLevel.dispose();
		currLevel = l;
		guiHelper.setPanelSize(l.width, l.height);
		l.em.registerEventHandlers(guiHelper.getFrame());
		if (wl == WindowLocation.CENTER) {
			guiHelper.centerFrame();
		}
	}
	
	public enum WindowLocation {
		CENTER,
		TOPLEFT
	}
}
