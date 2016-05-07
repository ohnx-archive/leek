package ca.masonx.leek.core.gameElement;

/**
 * Block Abstract Class.
 * 
 * No Entity can collide with this - the movement is prevented.
 */
public abstract class Block extends GameElement {
	/**
	 * Block constructor
	 * @param parent	The parent of this block (Which level is the entity in?)
	 */
	public Block(Level parent) {
		super(parent);
	}
}
