package ca.masonx.leek.core.events;

import java.util.ArrayList;
import java.util.List;

import ca.masonx.leek.core.world.GameElement;

public class CollisionEventManager {
	protected List<GameElement> subscribers = new ArrayList<GameElement>();
	
	public CollisionEventManager() {
	}
	
	public void addCollisionListener(GameElement ge) {
		subscribers.add(ge);
	}
	
	public List<GameElement> getSubscribers() {
		return subscribers;
	}

	public void removeCollisionListener(GameElement o) {
		subscribers.remove(o);
	}
}
