package ca.masonx.leek.core.render;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import ca.masonx.leek.core.world.Level;

/**
 * Text class.
 * 
 * Allows text to be displayed on the screen/game window.
 * 
 * Also example of something that needs to be rendered directly to the Graphics context.
 */
public class Text implements SpecialRenderer {
	/**
	 * The text of the Text. (What is being written/displayed?)
	 */
	public String text;
	
	/**
	 * X position of the center of the text.
	 */
	public int px;
	
	/**
	 * Y position of the center of the text.
	 */
	public int py;
	
	/**
	 * The Color of the text.
	 */
	public Color c;
	
	/**
	 * The Font that the text will be displayed in.
	 */
	public Font font;
	
	/**
	 * The parent level.
	 */
	private final Level parent;

	/**
	 * Create a new Text object, specifying all possible properties.
	 * 
	 * @param parent	The parent level that this Text belongs to.
	 * @param text		The text being displayed.
	 * @param xPos		The x position of the text.
	 * @param yPos		The y position of the text.
	 * @param font		The font used to display the text.
	 * @param c			The color of the text.
	 */
	public Text(Level parent, String text, int xPos, int yPos, Font font, Color c) {
		this.parent = parent;
		this.text = text;
		this.px = xPos;
		this.py = yPos;
		this.font = font;
		this.c = c;
	}

	/**
	 * Create a new Text object, with a white color.
	 * 
	 * @param parent	The parent level that this Text belongs to.
	 * @param text		The text being displayed.
	 * @param xPos		The x position of the text.
	 * @param yPos		The y position of the text.
	 * @param font		The font used to display the text.
	 */
	public Text(Level parent, String text, int xPos, int yPos, Font font) {
		this.parent = parent;
		this.text = text;
		this.px = xPos;
		this.py = yPos;
		this.font = font;
		this.c = Color.WHITE;
	}
	
	/**
	 * Create a new Text object with a default font and a white color.
	 * 
	 * @param parent	The parent level that this Text belongs to.
	 * @param text		The text being displayed.
	 * @param xPos		The x position of the text.
	 * @param yPos		The y position of the text.
	 */
	public Text(Level parent, String text, int xPos, int yPos) {
		this.parent = parent;
		this.text = text;
		this.px = xPos;
		this.py = yPos;
		this.font = new Font(Long.toString(System.currentTimeMillis()), Font.PLAIN, 12);
		this.c = Color.WHITE;
	}

	/* Text returns null when rendered normally since it doesn't draw a PositionedImage */
	public PositionedImage render() {
		return null;
	}

	/* ... instead, it draws directly to the Graphics context. */
	/**
	 * Render the Text.
	 * 
	 * @param g	The graphics context to draw on
	 */
	public void render(Graphics g) {
		// Set the properties
		g.setColor(c);
		g.setFont(font);
		// Draw the text
		g.drawString(text, px, py);
	}
	
	/**
	 * Get the parent level of the Text.
	 * 
	 * @return	The parent level.
	 */
	public Level getParent() {
		return parent;
	}
}
