package ca.masonx.minig;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ca.masonx.leek.core.annotations.LeekEventHandler;
import ca.masonx.leek.core.events.CollisionEvent;
import ca.masonx.leek.core.events.HandlerType;
import ca.masonx.leek.core.gameElement.Level;
import ca.masonx.leek.core.gameElement.MovableEntity;
import ca.masonx.leek.core.render.PositionedImage;

public class Player extends MovableEntity implements KeyListener {
	/**
	 * Make this serializable
	 */
	private static final long serialVersionUID = 66916044368560750L;
	
	
	private boolean[] keysPressed = {false, false, false, false};
	
	@LeekEventHandler(handles = HandlerType.COLLISION)
	public void collided(CollisionEvent e) {
		
	}
	
	public Player(Level l) {
		super(l);
	}
	
	public void update(double time) {
		// TODO Auto-generated method stub
		
	}
	
	public PositionedImage render() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			keysPressed[0] = true;
			break;
		case KeyEvent.VK_DOWN:
			keysPressed[1] = true;
			break;
		case KeyEvent.VK_LEFT:
			keysPressed[2] = true;
			break;
		case KeyEvent.VK_RIGHT:
			keysPressed[3] = true;
			break;
		default:
			return;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			keysPressed[0] = false;
			break;
		case KeyEvent.VK_DOWN:
			keysPressed[1] = false;
			break;
		case KeyEvent.VK_LEFT:
			keysPressed[2] = false;
			break;
		case KeyEvent.VK_RIGHT:
			keysPressed[3] = false;
			break;
		default:
			return;
		}
	}
	/* uneeded for the player class */
	public void keyTyped(KeyEvent e) {}
}
