package ca.masonx.leek.core.events;

/**
 * Event Handler priority.
 */
public enum HandlerPriority {
	/**
	 * HIGH: Called first.
	 */
	HIGH,
	
	/**
	 * MEDIUM: Called after all HIGH have been called.
	 */
	MEDIUM,
	
	/**
	 * LOW: Called after all MEDIUM have been called.
	 */
	LOW
}