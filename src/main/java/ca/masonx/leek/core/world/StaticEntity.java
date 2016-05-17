package ca.masonx.leek.core.world;


/**
 * Static Entity abstract class.
 * Static Entities are entities that do not move but still will interact with the player.
 */
public abstract class StaticEntity extends Entity {
	/**
	 * Make this serializable
	 */
	private static final long serialVersionUID = -1240254990808026555L;

	/**
	 * StaticEntity constructor
	 * @param parent	The parent of this entity (Which level is the entity in?)
	 */
	public StaticEntity(Level parent) {
		super(parent);
	}
}
