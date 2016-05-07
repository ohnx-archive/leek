package ca.masonx.leek.core.gameElement;

import java.awt.Rectangle;

import ca.masonx.leek.core.render.Renderable;

public abstract class GameElement implements Renderable {
	/**
	 * Position of the Game Element
	 */
	int px, py, pz;
	
	/**
	 * Length and width of the Game Element (used for collision detection)
	 */
	int height, width;
	
	/**
	 * Parent level
	 */
	private final Level parent;
	
	/**
	 * Entity constructor
	 * @param parent	The parent of this entity (Which level is the entity in?)
	 */
	public GameElement(Level parent) {
		this.parent = parent;
	}
	
	/**
	 * Get the bounding box of a Game Element
	 * @return bounding box
	 */
	public Rectangle getBounds() {
        return new Rectangle(px, py, width, height);
    }

	/**
	 * Get the parent of an entity
	 * @return	Parent level
	 */
	protected Level getParent() {
		return parent;
	}
}
