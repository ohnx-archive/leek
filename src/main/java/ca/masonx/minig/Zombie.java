package ca.masonx.minig;

import ca.masonx.leek.core.annotations.LeekEventHandler;
import ca.masonx.leek.core.events.CollisionEvent;
import ca.masonx.leek.core.events.EventHandlerRegister;
import ca.masonx.leek.core.events.HandlerType;
import ca.masonx.leek.core.events.Listener;

public class Zombie implements Listener {
	@LeekEventHandler(handles = HandlerType.COLLISION)
	public void collided(CollisionEvent e) {
		
	}
	public Zombie() {
		EventHandlerRegister.registerEventHandlers(this);
	}
}
