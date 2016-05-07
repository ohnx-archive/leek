package ca.masonx.leek.core.gameElement;


/**
 * Static Entity abstract class
 * Static Entities are entities that do not move but still will interact with the player
 */
public abstract class StaticEntity extends Entity {
	/**
	 * StaticEntity constructor
	 * @param parent	The parent of this entity (Which level is the entity in?)
	 */
	public StaticEntity(Level parent) {
		super(parent);
	}
}
