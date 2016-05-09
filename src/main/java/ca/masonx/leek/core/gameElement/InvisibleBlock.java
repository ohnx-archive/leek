package ca.masonx.leek.core.gameElement;

import ca.masonx.leek.core.render.PositionedImage;

/**
 * Invisible Block class.
 * 
 * Invisible Blocks are something that interacts with entities, but will not render.
 */
public class InvisibleBlock extends Block {
	/**
	 * Make this serializable
	 */
	private static final long serialVersionUID = 7109398440275459360L;

	/**
	 * InvisibleBlock constructor
	 * @param parent	The parent of this entity (Which level is the entity in?)
	 */
	public InvisibleBlock(Level parent) {
		super(parent);
	}

	/**
	 * Render self.
	 * @return	null (no image since it's invisible)
	 */
	public PositionedImage render() {
		/* Return null means don't draw anything for this */
		return null;
	}
}
