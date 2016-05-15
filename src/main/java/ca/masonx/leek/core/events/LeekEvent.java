package ca.masonx.leek.core.events;

import java.lang.reflect.Method;

/**
 * Leek Event base class.
 * 
 * Provides a number of helper methods for events.
 */
public abstract class LeekEvent {
	/**
	 * Check if the Method is a valid handler for a given HandlerType
	 * @param m		The method to check
	 * @param ht	The HandlerType to check
	 * @return		Whether or not the event handler is valid for the type (true = yes, false = no)
	 */
	protected static boolean checkValidEventHandler(Method m, HandlerType ht) {
		@SuppressWarnings("rawtypes")
		Class[] pt = m.getParameterTypes();
		/* make sure there is only 1 parameter */
		if (pt.length != 1) return false;
		/* switch based on the event type */
		switch (ht) {
		case COLLISION:
			if (pt[0].getCanonicalName().equals(CollisionEvent.class.getCanonicalName())) return true;
			break;
		case KEYDOWN:
			if (pt[0] == KeyDownEvent.class) return true;
			break;
		case KEYUP:
			if (pt[0] == KeyUpEvent.class) return true;
			break;
		case MOUSECLICK:
			if (pt[0] == MouseClickEvent.class) return true;
			break;
		case MOUSEMOVE:
			if (pt[0] == MouseMoveEvent.class) return true;
			break;
		case NONE:
		default:
			break;
		}
		return false;
	}
}
