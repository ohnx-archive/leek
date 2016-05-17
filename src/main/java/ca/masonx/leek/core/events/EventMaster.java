package ca.masonx.leek.core.events;

import java.awt.Panel;
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
 * Called to add event listeners, and to remove them.
 */
public class EventMaster {
	/**
	 * Event listeners.
	 */
	protected List<EventListener> eventListeners = new ArrayList<EventListener>();
	private Panel parentPanel;
	
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
	 * Add an event handler.
	 * 
	 * After adding the event handler,
	 * registerEventHandlers() must be run.
	 * 
	 * @param o The EventListener to add.
	 */
	public void addEventHandler(EventListener o) {
		eventListeners.add(o);
	}
	
	/**
	 * Register the events to a panel.
	 * 
	 * @param p	The panel to register events to.
	 */
	public void registerEventHandlers(Panel p) {
		parentPanel = p;
		for (Object o : eventListeners) {
			if (o instanceof KeyListener) {
				p.addKeyListener((KeyListener) o);
			}
			if (o instanceof MouseMotionListener) {
				p.addMouseMotionListener((MouseMotionListener) o);
			}
			if (o instanceof MouseListener) {
				p.addMouseListener((MouseListener) o);
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
	 * Remove the event handlers for a given EventListener from the panel.
	 * 
	 * @param o	The EventListener that will have its listeners removed.
	 */
	public void removeEventHandlers(EventListener o) {
		if (o instanceof KeyListener) {
			parentPanel.removeKeyListener((KeyListener) o);
		}
		if (o instanceof MouseMotionListener) {
			parentPanel.removeMouseMotionListener((MouseMotionListener) o);
		}
		if (o instanceof MouseListener) {
			parentPanel.removeMouseListener((MouseListener) o);
		}
		if (o instanceof CollisionListener) {
			if (o instanceof GameElement) {
				parent.cem.removeCollisionListener((GameElement) o);
			}
		}
		eventListeners.remove(o);
	}
}
