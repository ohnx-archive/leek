/*package ca.masonx.leek.misc;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class JukeBox8 {
	protected static List<ClipPlus> clipsPlaying = new ArrayList<ClipPlus>();
	
	public static int play(String filename) throws IOException {
		Media media = new Media((new java.io.File(filename)).toURI().toURL().toString());
	    MediaPlayer mediaPlayer = new MediaPlayer(media);
	    mediaPlayer.play();
	    System.out.println("ok");
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
*/