package ca.masonx.leek.core.gameElement;

/**
 * Block abstract class
 * No Entity can collide with this - the movement is prevented.
 */
public abstract class Block extends GameElement {
	public Block(Level parent) {
		super(parent);
	}
}
