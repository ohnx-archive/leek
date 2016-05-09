package ca.masonx.leek;

import ca.masonx.leek.core.events.LeekEvent;
import ca.masonx.leek.core.gui.LeekGuiHelper;

/**
 * Leek main class.
 * Programs that use Leek interface with this class (mostly).
 */
public class Leek extends LeekEvent {
	/**
	 * GUI helper for Leek
	 */
	private LeekGuiHelper guiHelper;
	
	public void init(String windowName, int width, int height) {
		guiHelper.initGUI(windowName, width, height);
	}
	
	public Leek() {
		guiHelper = new LeekGuiHelper();
	}
}
