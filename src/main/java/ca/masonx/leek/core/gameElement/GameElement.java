package ca.masonx.leek.core.gameElement;

import java.awt.Rectangle;

import ca.masonx.leek.core.render.Renderable;

/**
 * GameElement abstract class.
 * 
 * Everything that is inside a level extends this class.
 */
public abstract class GameElement implements Renderable, java.io.Serializable {
	/**
	 * Make this serializable
	 */
	private static final long serialVersionUID = -1525879088524198224L;

	/**
	 * Position of the game element
	 */
	int px, py, pz;
	
	/**
	 * Height and width of the Game Element (used for collision detection)
	 */
	int height, width;
	
	/**
	 * Parent level
	 */
	private final Level parent;
	
	/**
	 * Entity constructor
	 * @param parent	The parent of this entity (Which level is the element in?)
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
