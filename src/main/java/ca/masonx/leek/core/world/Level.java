package ca.masonx.leek.core.world;

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
import java.util.EventListener;
import java.util.List;

import ca.masonx.leek.core.events.CollisionEventManager;
import ca.masonx.leek.core.events.EventMaster;
import ca.masonx.leek.core.physics.Updateable;
import ca.masonx.leek.core.render.PositionedImage;
import ca.masonx.leek.core.render.Renderable;
import ca.masonx.leek.core.render.SpecialRenderer;

/**
 * Class for a level - most functionality is already implemented.
 * Extending this class is not necessary.
 */
public class Level implements Serializable {
	/**
	 * Make this serializable
	 */
	private static final long serialVersionUID = 4977710030815731043L;
	
	protected final String levelName;
	/* Level background image */
	protected final BufferedImage levelBackground;
	
	/* Level dimensions */
	public final int height;
	public final int width;
	
	/* Element lists */
	private List<Entity> entityList;
	private List<Block> blockList;
	private List<SpecialRenderer> specials;
	
	/* event masters and stuff */
	public final transient EventMaster em;
	public final transient CollisionEventManager cem;
	
	/* Queue for adding new elements */
	protected List<Entity> entityQueue;
	protected List<Block> blockQueue;
	protected List<Entity> entityRemoval;
	protected List<Block> blockRemoval;
	
	/**
	 * Level constructor.
	 * @param name			The name of the level (no use right now)
	 * @param background	The background for the level
	 */
	public Level(String name, BufferedImage background) {
		/* level properties */
		levelName = name;
		levelBackground = background;
		height = levelBackground.getHeight();
		width = levelBackground.getWidth();
		
		/* entity lists and queues */
		entityList = new ArrayList<Entity>();
		blockList = new ArrayList<Block>();
		specials = new ArrayList<SpecialRenderer>();
		entityQueue = new ArrayList<Entity>();
		blockQueue = new ArrayList<Block>();
		entityRemoval = new ArrayList<Entity>();
		blockRemoval = new ArrayList<Block>();
		
		/* Event Master and collision manager */
		em = new EventMaster(this);
		cem = new CollisionEventManager();
	}
	
	/**
	 * Render the level using a simple Painter's algorithm.
	 * 
	 * <b>Internal use only</b>
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
		
		/* draw the special things (ie, text) */
		for (SpecialRenderer sr : specials) {
			sr.render(g);
		}
	}
	
	/**
	 * Update the level.
	 * 
	 * <b>Internal use only</b>
	 * @param time the amount of time that has passed since the level last got updated
	 */
	public void update(double time) {
		/* call update() for the objects that have it */
		for (Entity e : entityList) {
			if (e instanceof Updateable) {
				((Updateable) e).update(time);
			}
		}
		
		/* add queue */
		for (Entity e : entityQueue) {
			entityList.add(e);
		}
		entityQueue.clear();
		for (Block b : blockQueue) {
			blockList.add(b);
		}
		blockQueue.clear();

		/* remove queue */
		for (Entity e : entityRemoval) {
			entityList.remove(e);
			/* need to also unregister all event listeners */
			if (e instanceof EventListener) {
				em.removeEventHandlers((EventListener)e);
			}
		}
		entityRemoval.clear();
		
		for (Block b : blockRemoval) {
			blockList.remove(b);
		}
		blockRemoval.clear();
	}
	
	/**
	 * Dispose of the level.
	 * 
	 * Call when switching levels to unload all the entities and whatnot,
	 * and to unregister the event handlers.
	 */
	public void dispose() {
		/* entity queue */
		for (Entity e : entityList) {
			/* need to also unregister all event listeners */
			if (e instanceof EventListener) {
				em.removeEventHandlers((EventListener)e);
			}
		}
		
		/* clear all the event handlers */
		entityList.clear();
		blockList.clear();
		entityQueue.clear();
		blockQueue.clear();
		entityRemoval.clear();
		blockRemoval.clear();
		specials.clear();
	}
	
	/**
	 * Add an entity to the level.
	 * @param e	The entity to add.
	 */
	public void add(Entity e) {
		entityQueue.add(e);
	}
	
	/**
	 * Add a block to the level.
	 * @param b	The block to add.
	 */
	public void add(Block b) {
		blockQueue.add(b);
	}
	
	/**
	 * Add a Special Renderer to the queue.
	 * @param sr	The Special Renderer.
	 */
	public void add(SpecialRenderer sr) {
		specials.add(sr);
	}
	
	/**
	 * Get the entity list.
	 * 
	 * Mostly only useful internally.
	 * @return	The entity list.
	 */
	public List<Entity> getEntityList() {
		return entityList;
	}
	
	/**
	 * Get the block list.
	 * 
	 * Mostly only useful internally.
	 * @return	The block list.
	 */
	public List<Block> getBlockList() {
		return blockList;
	}
	
	/**
	 * Remove the entity e level.
	 * The entity will no longer render or update from this level.
	 * Will unregister event handlers for the entity as well.
	 * 
	 * @param e	The Entity to remove
	 */
	public void removeEntity(Entity e) {
		entityRemoval.add(e);
	}
	
	/**
	 * Remove the block b from the level.
	 * The block will no longer render from this level.
	 * Will unregister event handlers for the entity as well.
	 * 
	 * @param b	The Block to remove
	 */
	public void removeBlock(Block b) {
		blockRemoval.add(b);
	}
	
	/**
	 * Load a level state from a string.
	 * 
	 * @param in						The input string
	 * @return							The un-serialized level
	 * @throws IOException				Exception thrown from un-serializing
	 * @throws ClassNotFoundException	Exception thrown from un-serializing
	 * @throws ClassCastException		Exception thrown from un-serializing
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
