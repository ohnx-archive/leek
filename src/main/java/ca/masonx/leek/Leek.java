package ca.masonx.leek;

import java.awt.Graphics;

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
		double dt = 1.0 / targetFPS * 1000.0;
		double currentTime = System.currentTimeMillis();
		double newTime;
		double frameTime;
		double deltaTime;
		Graphics g = guiHelper.getGraphics();
		//Graphics buffer = new Graphics();
		
		while (true) {
			newTime = System.currentTimeMillis();
			frameTime = newTime - currentTime;
			currentTime = newTime;
			
			while (frameTime > 0.0) {
				deltaTime = Math.min(frameTime, dt);
				currLevel.update(deltaTime);
				frameTime -= deltaTime;
			}
			
		    currLevel.render(g);
		    if (false)
		    	break;
		}
		return false;
	}
	
	public void changeLevel(Level l) {
		//TODO: Transition nicely to the next level
		currLevel = l;
		guiHelper.setPanelSize(l.width, l.height);
		guiHelper.setFrameSize(l.width, l.height);
	}
}
