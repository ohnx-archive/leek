package ca.masonx.leek.core.gameElement;

/**
 * Entity Abstract Class.
 * 
 * Contains basic properties and methods that all Entities have.
 */
public abstract class Entity extends GameElement {
	/**
	 * Make this serializable
	 */
	private static final long serialVersionUID = -251721415291916973L;

	/**
	 * Entity constructor
	 * @param parent	The parent of this entity (Which level is the entity in?)
	 */
	public Entity(Level parent) {
		super(parent);
	}
}
