package ca.masonx.leek.misc;

import javax.sound.sampled.Clip;

/**
 * Simple wrapper around Clip, 
 * just for the extra information of the last play time.
 */
public class ClipPlus {
	public Clip clip;
	public int lastPlayTime;
	
	public ClipPlus(Clip clip, int playTime) {
		this.clip = clip;
		this.lastPlayTime = playTime;
	}
}
