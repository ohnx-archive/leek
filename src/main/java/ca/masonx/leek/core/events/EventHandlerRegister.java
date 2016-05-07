package ca.masonx.leek.core.events;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import ca.masonx.leek.core.annotations.LeekEventHandler;

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
	 * @param in	A class that implements the Listener interface.
	 */
	public static void registerEventHandlers(Listener in) {
		Class<?> cours = in.getClass();
		Method[] methods = cours.getMethods();
		for (Method method : methods) {
			// if method is annotated with @Test
			if (method.isAnnotationPresent(LeekEventHandler.class)) {
				Annotation annotation = method.getAnnotation(LeekEventHandler.class);
				LeekEventHandler handler = (LeekEventHandler) annotation;
				switch (handler.handles()) {
				case COLLISION:
					break;
				case KEYDOWN:
					break;
				case KEYUP:
					break;
				case MOUSECLICK:
					break;
				case MOUSEMOVE:
					break;
				default:
					System.err.println("Invalid handling type for: " + method.getName());
					break;
				}
			}
		}
	}
}
