package ca.masonx.leek.core.gameElement;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.masonx.leek.core.events.EventMaster;
import ca.masonx.leek.core.physics.Updateable;
import ca.masonx.leek.core.render.PositionedImage;
import ca.masonx.leek.core.render.Renderable;

/**
 * Class for a level - most functionality is already implemented.
 * Extending this class is not necessary.
 */
public class Level implements Serializable{
	/**
	 * Make this serializable
	 */
	private static final long serialVersionUID = 4977710030815731043L;
	
	protected final String levelName;
	/**
	 * Level background image
	 */
	protected final BufferedImage levelBackground;
	protected List<Entity> entityList;
	protected List<Block> blockList;
	public final transient EventMaster em;
	
	/**
	 * Level constructor
	 * @param name			The name of the level (no use right now)
	 * @param background	The background for the level
	 */
	public Level(String name, BufferedImage background) {
		levelName = name;
		levelBackground = background;
		entityList = new ArrayList<Entity>();
		blockList = new ArrayList<Block>();
		em = new EventMaster();
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
	 * @param time the amount of time that has passed since the level last got updatedz
	 */
	public void update(int time) {
		for (Entity e : entityList) {
			if (e instanceof Updateable) {
				((Updateable) e).update(time);
			}
		}
	}
	
	/**
	 * Load a level state from a string.
	 * 
	 * @param in						The input string
	 * @return							The un-serialized level
	 * @throws IOException				Exception thrown from un-serializing
	 * @throws ClassNotFoundException	Exception thrown from un-serializing
	 */
	public static Level loadLevel(String in) throws IOException, ClassNotFoundException, ClassCastException {
		byte b[] = in.getBytes(); 
		ByteArrayInputStream bi = new ByteArrayInputStream(b);
		ObjectInputStream si = new ObjectInputStream(bi);
		return (Level) si.readObject();
	}
	
	/**
	 * Save a level state to a string.
	 * @param l					Input level
	 * @return					A string containing the serialized level
	 * @throws IOException		Exception thrown from serializing
	 */
	public static String exportLevel(Level l) throws IOException {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream so = new ObjectOutputStream(bo);
		so.writeObject(l);
		so.flush();
		return bo.toString();
	}
}
