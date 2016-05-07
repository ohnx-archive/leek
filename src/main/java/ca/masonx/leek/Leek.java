package ca.masonx.leek;

import ca.masonx.leek.core.gui.LeekGuiHelper;

/**
 * Leek main class
 */
public class Leek {
	public static void init(String windowName, int width, int height) {
		LeekGuiHelper guiHelper;
		guiHelper = new LeekGuiHelper();
		guiHelper.initGUI(windowName, width, height);
	}
}
