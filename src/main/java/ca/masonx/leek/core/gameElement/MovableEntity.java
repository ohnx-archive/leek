package ca.masonx.leek.core.gameElement;

import ca.masonx.leek.core.physics.Updateable;

/**
 * Movable Entity abstract class
 * 
 * Movable Entities are entities that can move.
 */
public abstract class MovableEntity extends Entity implements Updateable {
	public MovableEntity(Level parent) {
		super(parent);
	}
}
