package ca.masonx.leek.core.physics;

/**
 * Updateable interface
 * Everything that needs to be updated at some point in time will implement this.
 */
public interface Updateable {
	/**
	 * Update everything.
	 * @param time	The amount of time that has passed since the last update
	 */
	public void update(int time);
}
