package ca.masonx.leek.core.gameElement;

/**
 * Entity Abstract Class.
 * 
 * Contains basic properties and methods that all Entities have.
 */
public abstract class Entity extends GameElement {
	/**
	 * Entity constructor
	 * @param parent	The parent of this entity (Which level is the entity in?)
	 */
	public Entity(Level parent) {
		super(parent);
	}
}
