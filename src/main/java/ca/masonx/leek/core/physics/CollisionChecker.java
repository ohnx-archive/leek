package ca.masonx.leek.core.physics;

import java.awt.Rectangle;
import java.util.List;

import ca.masonx.leek.core.events.CollisionListener;
import ca.masonx.leek.core.world.Block;
import ca.masonx.leek.core.world.GameElement;
import ca.masonx.leek.core.world.Level;

public class CollisionChecker {
	/**
	 * Check the collisions in a level and then notify
	 * whoever wants to know about collisions.
	 * 
	 * @param l	The level to check collisions in.
	 */
	public static void checkCollisions(Level l) {
		// get list of subscribers
		List<GameElement> checkList = l.cem.getSubscribers();
		
		// loop through list
		for (GameElement e : checkList) {
			Rectangle r = e.getBounds();
			/* Check intersections with the entities.
			 * blocks, by definition, should not be collided with. */
			for (GameElement check : l.getEntityList()) {
				if (r.intersects(check.getBounds())) {
					((CollisionListener)e).collidedWith(check);
				}
			}
		}
	}
	
	/**
	 * Check if an entity can move somewhere (ie, it intersects with a Block).
	 * 
	 * @param l		The level to check in
	 * @param xpos	The x position of the object to check
	 * @param ypos	The y position of the object to check
	 * @param height	The height of the object to check
	 * @param width		The width of the object to check
	 * @return		Whether or not the object can move there (true = yes, false = no)
	 */
	public static boolean canMoveHere(Level l, int xpos, int ypos, int height, int width) {
		Rectangle r = new Rectangle(xpos, ypos, width, height);
		// Check all the Blocks in a level
		for (Block b : l.getBlockList()) {
			if (r.intersects(b.getBounds())) {
				return false;
			}
		}
		return true;
	}
 }
