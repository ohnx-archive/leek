package ca.masonx.leek.core.events;

import ca.masonx.leek.core.gameElement.GameElement;

/**
 * Collision listener interface.
 * 
 * Classes that want to know about collisions with
 * other game elements can implement this class.
 */
public interface CollisionListener {
	/**
	 * The object colliding with this game element.
	 * @param ge
	 */
	public void collidedWith(GameElement ge);
}
