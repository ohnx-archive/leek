package ca.masonx.leek.core.events;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import ca.masonx.leek.core.annotations.LeekEventHandler;

public class EventHandlerRegister {
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
				case KEYBOARD:
					break;
				case MOUSECLICK:
					break;
				case MOUSEMOVE:
					break;
				case NONE:
					break;
				}
			}
		}
	}
}
