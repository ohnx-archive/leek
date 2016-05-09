package ca.masonx.minig;

import ca.masonx.leek.core.annotations.LeekEventHandler;
import ca.masonx.leek.core.events.CollisionEvent;
import ca.masonx.leek.core.events.EventHandlerRegister;
import ca.masonx.leek.core.events.HandlerType;
import ca.masonx.leek.core.events.Listener;
import ca.masonx.leek.core.gameElement.Level;
import ca.masonx.leek.core.gameElement.MovableEntity;
import ca.masonx.leek.core.render.PositionedImage;

public class Player extends MovableEntity implements Listener {
	/**
	 * Make this serializable
	 */
	private static final long serialVersionUID = 66916044368560750L;
	
	@LeekEventHandler(handles = HandlerType.COLLISION)
	public void collided(CollisionEvent e) {
		
	}
	public Player(Level l) {
		super(l);
		EventHandlerRegister.registerEventHandlers(l, this);
	}
	
	public void update(int time) {
		// TODO Auto-generated method stub
		
	}
	public PositionedImage render() {
		// TODO Auto-generated method stub
		return null;
	}
}
