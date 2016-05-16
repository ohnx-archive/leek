package ca.masonx.leek.core.physics;

import java.awt.Rectangle;
import java.util.List;

import ca.masonx.leek.core.events.CollisionListener;
import ca.masonx.leek.core.world.GameElement;
import ca.masonx.leek.core.world.Level;

public class CollisionChecker {
	public static void checkCollisions(Level l) {
		List<GameElement> checkList = l.cem.getSubscribers();
		for (GameElement e : checkList) {
			Rectangle r = e.getBounds();
			for (GameElement check : l.getEntityList()) {
				if (r.intersects(check.getBounds())) {
					((CollisionListener)e).collidedWith(check);
				}
			}
			for (GameElement check : l.getBlockList()) {
				if (r.intersects(check.getBounds())) {
					((CollisionListener)e).collidedWith(check);
				}
			}
		}
	}
 }
