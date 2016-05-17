package ca.masonx.leek.core.events;

import java.util.ArrayList;
import java.util.List;

import ca.masonx.leek.core.world.GameElement;

/**
 * Collision event manager.
 * 
 * Keeps track of which classes want to be notified of collision events.
 * 
 * Every level has a collision event manager, which used when
 * checking collisions in CollisionChecker.checkCollisions (called every game loop).
 */
public class CollisionEventManager {
	/**
	 * Who is listening to the collision events.
	 */
	protected List<GameElement> subscribers = new ArrayList<GameElement>();
	
	public CollisionEventManager() {
	}
	
	/**
	 * Add a collision listener.
	 * @param ge	The GameElement that wants to listen to collision events.
	 */
	public void addCollisionListener(GameElement ge) {
		subscribers.add(ge);
	}
	
	/**
	 * Get the list of classes listening to the collision events.
	 * @return	The list of classes listening to the collision events.
	 */
	public List<GameElement> getSubscribers() {
		return subscribers;
	}

	/**
	 * Remove a collision listener.
	 * 
	 * @param o	The GameElement that should no longer listen to collision events.
	 */
	public void removeCollisionListener(GameElement o) {
		subscribers.remove(o);
	}
}
