package ca.masonx.leek.core.events;

import java.util.EventListener;

import ca.masonx.leek.core.world.GameElement;

/**
 * Collision listener interface.
 * 
 * Classes that want to know about collisions with
 * other game elements must implement this class.
 */
public interface CollisionListener extends EventListener {
	/**
	 * Called when an object collided with this game element.
	 * @param ge	The other game element that collided with this game element.
	 */
	public void collidedWith(GameElement ge);
}
