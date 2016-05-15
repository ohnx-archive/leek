package ca.masonx.leek.core.events;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import ca.masonx.leek.Leek;
import ca.masonx.leek.core.annotations.LeekEventHandler;
import ca.masonx.leek.core.gameElement.Level;

/**
 * Event Handler Registerer.
 * 
 * Uses Reflection to parse the annotations and checks for the @LeekEventHandler annotation.
 */
public class EventHandlerRegister {
	/**
	 * Register the event handlers for a given class.
	 * 
	 * Sample usage (assuming called from a class that implements Listener): registerEventHandlers(this).
	 * 
	 * @param l		The level that the event handler is going to be registered under
	 * @param in	A class that implements the Listener interface.
	 */
	public static void registerEventHandlers(Level l, Object in) {
		Class<?> cours = in.getClass();
		if (cours.isAnnotationPresent(LeekEventHandler.class)) {
			Annotation annotation = cours.getAnnotation(LeekEventHandler.class);
			LeekEventHandler handler = (LeekEventHandler) annotation;
			/*
			switch (handler.handles()) {
			case COLLISION:
			case KEYDOWN:
			case KEYUP:
			case MOUSECLICK:
			case MOUSEMOVE:
				if (l.em.addEventHandler(method, handler.handles())) {
					
				} else {
					System.err.println("Invalid event handler " + method.getName() + " in " + in.getClass().getName());
				}
				break;
			default:
				System.err.println("Invalid handling type for: " + method.getName() + " in " + in.getClass().getName());
				break;
			}*/
		}
	}
}
