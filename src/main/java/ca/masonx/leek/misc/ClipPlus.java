package ca.masonx.leek.misc;

import javax.sound.sampled.Clip;

public class ClipPlus {
	public Clip clip;
	public int lastPlayTime;
	
	public ClipPlus(Clip clip, int playTime) {
		this.clip = clip;
		this.lastPlayTime = playTime;
	}
}
