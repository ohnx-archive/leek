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
	 * GUI helper for Leek.
	 */
	protected LeekGuiHelper guiHelper;
	
	/**
	 * Manager for collision events.
	 */
	protected CollisionEventManager cem;
	
	/**
	 * The current level that is being displayed.
	 */
	protected Level currLevel = null;
	
	/**
	 * Whether or not the level should change.
	 */
	protected boolean shouldChangeLevel = false;
	
	/**
	 * The level to change to, if it should change levels.
	 */
	protected Level toChange;
	
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
			
			// Check if anything has requested a level change
			if (shouldChangeLevel) {
				// dispose of this current level
				currLevel.dispose();
				// switch to the new one
				currLevel = toChange;
				// re-setup everything
				guiHelper.setPanelSize(toChange.width, toChange.height);
				currLevel.em.registerEventHandlers(guiHelper.getPanel());
				if (wl == WindowLocation.CENTER) {
					guiHelper.centerFrame();
				}
				// Recreate all the variables
				d = guiHelper.getPanelDimensions();
				bufh = d.height;
				bufw = d.width;
				
				// recreate the back buffer
				bufferImg = p.createImage(bufw, bufh);
				buffer = bufferImg.getGraphics();
				shouldChangeLevel = false;
				// skip this render
				continue;
			}
			
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
	 * Load the initial level.
	 * 
	 * @param l	Level to load.
	 */
	public void loadInitialLevel(Level l) {
		if (currLevel == null) {
			currLevel = l;
			guiHelper.setPanelSize(l.width, l.height);
			l.em.registerEventHandlers(guiHelper.getPanel());
			if (wl == WindowLocation.CENTER) {
				guiHelper.centerFrame();
			}
		}
	}
	
	/**
	 * Request to change the level.
	 * 
	 * @param l	The level to change to.
	 */
	public void requestChangeLevel(Level l) {
		if (currLevel == null) {
			loadInitialLevel(l);
			return;
		}
		shouldChangeLevel = true;
		toChange = l;
	}
	
	public enum WindowLocation {
		CENTER,
		TOPLEFT
	}
}
