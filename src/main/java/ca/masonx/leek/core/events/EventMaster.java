package ca.masonx.leek.core.events;

import java.awt.Frame;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import ca.masonx.leek.core.world.GameElement;
import ca.masonx.leek.core.world.Level;

/**
 * EventMaster.
 * 
 * Acts as the Event Master for a level.
 * Called to add event listeners, and 
 */
public class EventMaster {
	/**
	 * Event listeners.
	 */
	protected List<Object> eventListeners = new ArrayList<Object>();
	private Frame parentFrame;
	
	/**
	 * Parent level.
	 */
	private final Level parent;
	
	/**
	 * Instantiation of the parent level.
	 * @param parent	The parent level
	 */
	public EventMaster(Level parent) {
		this.parent = parent;
	}
	
	/**
	 * 
	 * @param o
	 */
	public void addEventHandler(Object o) {
		eventListeners.add(o);
	}
	
	/**
	 * 
	 * @param f
	 */
	public void registerEventHandlers(Frame f) {
		parentFrame = f;
		for (Object o : eventListeners) {
			if (o instanceof KeyListener) {
				f.addKeyListener((KeyListener) o);
			}
			if (o instanceof MouseMotionListener) {
				f.addMouseMotionListener((MouseMotionListener) o);
			}
			if (o instanceof MouseListener) {
				f.addMouseListener((MouseListener) o);
			}
			if (o instanceof CollisionListener) {
				if (o instanceof GameElement) {
					parent.cem.addCollisionListener((GameElement) o);
				} else {
					System.err.println(o.getClass().getName() +
					" is not a game element yet tried to register for collision events! Ignoring.");
				}
			}
		}
	}
	
	/**
	 * 
	 * @param o
	 */
	public void removeEventHandlers(EventListener o) {
		if (o instanceof KeyListener) {
			parentFrame.removeKeyListener((KeyListener) o);
		}
		if (o instanceof MouseMotionListener) {
			parentFrame.removeMouseMotionListener((MouseMotionListener) o);
		}
		if (o instanceof MouseListener) {
			parentFrame.removeMouseListener((MouseListener) o);
		}
		if (o instanceof CollisionListener) {
			if (o instanceof GameElement) {
				parent.cem.removeCollisionListener((GameElement) o);
			}
		}
	}
}
