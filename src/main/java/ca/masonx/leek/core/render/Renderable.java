package ca.masonx.leek.core.render;

/**
 * Renderable interface
 * 
 * Everything that will draw to the screen must implement this.
 */
public interface Renderable {
	/**
	 * Render self.
	 * @return	A positioned image (can be null if not rendered)
	 */
	public PositionedImage render();
}
