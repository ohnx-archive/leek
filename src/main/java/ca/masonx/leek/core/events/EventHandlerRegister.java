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
	public static void registerEventHandlers(Level l, Listener in) {
		Class<?> cours = in.getClass();
		Method[] methods = cours.getMethods();
		for (Method method : methods) {
			// if method is annotated with @Test
			if (method.isAnnotationPresent(LeekEventHandler.class)) {
				Annotation annotation = method.getAnnotation(LeekEventHandler.class);
				LeekEventHandler handler = (LeekEventHandler) annotation;
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
				default:
					System.err.println("Invalid handling type for: " + method.getName() + " in " + in.getClass().getName());
					break;
				}
			}
		}
	}
}
