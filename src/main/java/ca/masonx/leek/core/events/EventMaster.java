package ca.masonx.leek.core.events;

import java.awt.Panel;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * 
	 * @param o
	 */
	public void addEventHandler(Object o) {
		eventListeners.add(o);
	}
	
	public void registerEventHandlers(Panel p) {
		for (Object o : eventListeners) {
			try {
				p.addKeyListener((KeyListener) o);
			} catch (ClassCastException e) {}
			try {
				p.addMouseMotionListener((MouseMotionListener) o);
			} catch (ClassCastException e) {}
			try {
				p.addMouseListener((MouseListener) o);
			} catch (ClassCastException e) {}
			/*try {
				CollisionListener.
			} catch (ClassCastException e) {}*/
		}
	}
}
