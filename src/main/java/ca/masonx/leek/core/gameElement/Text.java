package ca.masonx.leek.core.gameElement;

import ca.masonx.leek.core.render.PositionedImage;

public class Text extends GameElement {
	/**
	 * Make this serializable
	 */
	private static final long serialVersionUID = 7030761358625174417L;

	protected String text;

	public Text(Level parent, String text) {
		super(parent);
		this.text = text;
	}

	public PositionedImage render() {
		return null;
	}

}
