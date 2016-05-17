package ca.masonx.leek.misc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class JukeBox {
	protected static List<ClipPlus> clipsPlaying = new ArrayList<ClipPlus>();
	
	public static int play(String filename) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filename));
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
		clipsPlaying.add(new ClipPlus(clip, 0));
		return clipsPlaying.size()-1;
	}
	
	public static void play(int handler) {
		ClipPlus target = clipsPlaying.get(handler);
		target.clip.setFramePosition(target.lastPlayTime);
		target.clip.start();
	}
	
	public static void pause(int handler) {
		ClipPlus target = clipsPlaying.get(handler);
		target.clip.stop();
		target.lastPlayTime = target.clip.getFramePosition();
	}
	
	public static void stop(int handler) {
		clipsPlaying.remove(handler);
	}
	
	public static void setLoopMode(int handler, int option) {
		clipsPlaying.get(handler).clip.loop(option);
	}
}
