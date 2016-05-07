package ca.masonx.leek.core.render;

import java.awt.image.BufferedImage;

/**
 * Positioned Image class
 * An Image that has a position so an algorithm can be used to figure out what goes on top of what.
 */
public class PositionedImage implements Comparable<PositionedImage> {
	public final BufferedImage i;
	public final int px;
	public final int py;
	public final int pz;
	
	/**
	 * Constructor for PositionedImage
	 * @param i		image
	 * @param px	z position of image
	 * @param py	y position of image
	 * @param pz	z position of image
	 */
	public PositionedImage(BufferedImage i, int px, int py, int pz) {
		this.i = i;
		this.px = px;
		this.py = py;
		this.pz = pz;
	}

	/**
	 * Compare function for PositionedImage - used in sorting
	 */
	public int compareTo(PositionedImage o) {
		if (this.pz < o.pz){
            return -1;
        }else{
            return 1;
        }
	}
}
