package ca.masonx.leek.core.gameElement;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.masonx.leek.core.physics.Updateable;
import ca.masonx.leek.core.render.PositionedImage;
import ca.masonx.leek.core.render.Renderable;

/**
 * Class for a level - most functionality is already implemented.
 * Extending this class is not necessary.
 */
public class Level {
	/**
	 * Level background image
	 */
	protected final BufferedImage levelBackground;
	protected List<Entity> entityList;
	protected List<Block> blockList;
	
	/**
	 * Level constructor
	 * @param background	The background for the level
	 */
	public Level(BufferedImage background) {
		levelBackground = background;
		entityList = new ArrayList<Entity>();
		blockList = new ArrayList<Block>();
		
	}
	
	/**
	 * Render the level using a simple Painter's algorithm
	 * @param g	The Graphics context to draw on
	 */
	public void render(Graphics g) {
		/* Create a new list with everything that has been rendered */
		List<PositionedImage> renderedImages = new ArrayList<PositionedImage>();
		
		PositionedImage pi;
		/* render all the entities */
		for (Renderable r : entityList) {
			pi = r.render();
			if (pi != null) renderedImages.add(pi);
		}
		
		/* render all the blocks */
		for (Renderable r : blockList) {
			pi = r.render();
			if (pi != null) renderedImages.add(pi);
		}
		
		/* sort the rendered images by z index */
		Collections.sort(renderedImages);
		
		g.drawImage(levelBackground, 0, 0, null);
		
		for (PositionedImage p : renderedImages) {
			g.drawImage(p.i, p.px, p.py, null);
		}
	}
	
	/**
	 * Update the level
	 * @param time
	 */
	public void update(int time) {
		for (Entity e : entityList) {
			if (e instanceof Updateable) {
				((Updateable) e).update(time);
			}
		}
	}
	
	/*
	public static Level loadLevel(String filename) {
		return new Level(new Image());
	}*/
}
