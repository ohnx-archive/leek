package ca.masonx.leek.core.render;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import ca.masonx.leek.core.world.Level;

public class Text implements SpecialRenderer {
	public String text;
	public int px;
	public int py;
	public Color c;
	public Font font;
	private final Level parent;

	public Text(Level parent, String text, int xPos, int yPos, Font font, Color c) {
		this.parent = parent;
		this.text = text;
		this.px = xPos;
		this.py = yPos;
		this.font = font;
		this.c = c;
	}
	
	public Text(Level parent, String text, int xPos, int yPos, Font font) {
		this.parent = parent;
		this.text = text;
		this.px = xPos;
		this.py = yPos;
		this.font = font;
		this.c = Color.WHITE;
	}
	
	public Text(Level parent, String text, int xPos, int yPos) {
		this.parent = parent;
		this.text = text;
		this.px = xPos;
		this.py = yPos;
		this.font = new Font(Long.toString(System.currentTimeMillis()), Font.PLAIN, 12);
		this.c = Color.WHITE;
	}

	public PositionedImage render() {
		return null;
	}

	public void render(Graphics g) {
		g.setColor(c);
		g.setFont(font);
		g.drawString(text, px, py);
	}
	
	public Level getParent() {
		return parent;
	}
}
