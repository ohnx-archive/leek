package ca.masonx.leek.core.events;

import java.util.EventListener;

import ca.masonx.leek.core.world.GameElement;

/**
 * Collision listener interface.
 * 
 * Classes that want to know about collisions with
 * other game elements can implement this class.
 */
public interface CollisionListener extends EventListener {
	/**
	 * The object colliding with this game element.
	 * @param ge
	 */
	public void collidedWith(GameElement ge);
}
