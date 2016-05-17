package ca.masonx.leek.core.render;

import java.awt.Graphics;

/**
 * Special renderer class.
 * 
 * Some classes need direct access to the Graphics context (ie, text),
 * so they must implement this class.
 */
public interface SpecialRenderer {
	/**
	 * Render the thing.
	 * 
	 * @param g	The Graphics context to draw directly onto.
	 */
	public void render(Graphics g);
}
