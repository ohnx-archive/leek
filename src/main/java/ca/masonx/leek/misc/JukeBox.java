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

/**
 * JukeBox class.
 * 
 * Provides a transparent wrapper around sound.
 * Right now, JukeBox uses javax.sound.sampled.Clip, 
 * but since it may change in the future, the JukeBox class
 * allows for code reuse without needing to rewrite sound-related things.
 */
public class JukeBox {
	/**
	 * List of all the clips playing right now.
	 * The handler is the index of the clip.
	 */
	protected static List<ClipPlus> clipsPlaying = new ArrayList<ClipPlus>();
	
	/**
	 * Load a sound file to memory.
	 * 
	 * Currently only works with .wav files.
	 * 
	 * @param filename			The filename of the audio file to load to memory.
	 * @return					The handler of the new clip that has been loaded.
	 * @throws IOException		Could not open the file.
	 * @throws UnsupportedAudioFileException	File type is not supported.
	 * @throws LineUnavailableException			File is already open in another application.
	 */
	public static int load(String filename) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filename));
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clipsPlaying.add(new ClipPlus(clip, 0));
		return clipsPlaying.size()-1;
	}
	
	/**
	 * Load and play a sound file.
	 * 
	 * Currently only works with .wav files.
	 * 
	 * @param filename			The filename of the audio file to start playing.
	 * @return					The handler of the new clip that has begun playing.
	 * @throws IOException		Could not open the file.
	 * @throws UnsupportedAudioFileException	File type is not supported.
	 * @throws LineUnavailableException			File is already open in another application.
	 */
	public static int play(String filename) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		play(load(filename));
		return clipsPlaying.size()-1;
	}
	
	/**
	 * Play the clip.
	 * 
	 * @param handler	The handler of the clip.
	 */
	public static void play(int handler) {
		ClipPlus target = clipsPlaying.get(handler);
		target.clip.setFramePosition(target.lastPlayTime);
		target.clip.start();
	}
	
	/**
	 * Pause the clip.
	 * 
	 * @param handler	The handler of the clip.
	 */
	public static void pause(int handler) {
		ClipPlus target = clipsPlaying.get(handler);
		target.clip.stop();
		target.lastPlayTime = target.clip.getFramePosition();
	}
	
	/**
	 * Stop playing the clip.
	 * 
	 * @param handler	The handler of the clip.
	 */
	public static void stop(int handler) {
		// we can't remove it, otherwise all the handlers will change
		clipsPlaying.get(handler).clip.stop();
	}
	
	/**
	 * Set the loop mode for the clip.
	 * 
	 * @param handler	The handler of the clip.
	 * @param option	The loop mode.
	 */
	public static void setLoopMode(int handler, int option) {
		clipsPlaying.get(handler).clip.loop(option);
	}
}
