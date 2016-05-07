package ca.masonx.leek.core.events;

/**
 * Event Handler type.
 * KEYBOARD: Called first.
 * MEDIUM: Called after all HIGH have been called.
 * LOW: Called after all MEDIUM have been called.
 */
public enum HandlerType {
	/**
	 * KEYDOWN: A key was pressed
	 */
	KEYDOWN,
	
	/**
	 * KEYUP: A key was released
	 */
	KEYUP,
	
	/**
	 * MOUSEMOVE: The mouse was moved
	 */
	MOUSEMOVE,
	
	/**
	 * MOUSECLICK: The mouse was clicked
	 */
	MOUSECLICK,
	
	/**
	 * COLLISION: Two entities have collided
	 */
	COLLISION,
	
	/**
	 * Invalid HandlerType
	 */
	NONE
}
