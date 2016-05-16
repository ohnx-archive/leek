package ca.masonx.leek.core.world;

/**
 * Block Abstract Class.
 * 
 * No Entity can collide with this - the movement is prevented.
 */
public abstract class Block extends GameElement {
	/**
	 * Make this serializable
	 */
	private static final long serialVersionUID = 8982104834579269130L;

	/**
	 * Block constructor
	 * @param parent	The parent of this block (Which level is the entity in?)
	 */
	public Block(Level parent) {
		super(parent);
	}
}
