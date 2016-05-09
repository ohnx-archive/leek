package ca.masonx.leek.core.gameElement;

import ca.masonx.leek.core.physics.Updateable;

/**
 * Movable Entity abstract class
 * 
 * Movable Entities are entities that can move.
 */
public abstract class MovableEntity extends Entity implements Updateable {
	/**
	 * Make this serializable
	 */
	private static final long serialVersionUID = 3414146955998883971L;

	/**
	 * MovableEntity constructor
	 * @param parent	The parent of this entity (Which level is the entity in?)
	 */
	public MovableEntity(Level parent) {
		super(parent);
	}
}
