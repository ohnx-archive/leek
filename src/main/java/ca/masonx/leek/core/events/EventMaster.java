package ca.masonx.leek.core.events;

import java.lang.reflect.Method;
import java.util.List;

public class EventMaster {
	/* All of the events and their catchers */
	List<Method> keyDown;
	List<Method> keyUp;
	List<Method> collision;
	List<Method> mouseMove;
	List<Method> mouseClick;
	
	/**
	 * Add event handler.
	 * 
	 * @param m		Method that is being registered
	 * @param et	Type that is being handled
	 * @return		Returns true on success, false on failure
	 */
	public boolean addEventHandler(Method m, HandlerType et) {
		if (LeekEvent.checkValidEventHandler(m, et)) {
			switch (et) {
			case COLLISION:
				collision.add(m);
				break;
			case KEYDOWN:
				keyDown.add(m);
				break;
			case KEYUP:
				keyUp.add(m);
				break;
			case MOUSECLICK:
				mouseClick.add(m);
				break;
			case MOUSEMOVE:
				mouseMove.add(m);
				break;
			case NONE:
			default:
				break;
			}
			return true;
		}
		return false;
	}
}
