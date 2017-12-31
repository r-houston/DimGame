/**
 * 
 */
package me.gamedev.dim;

import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

/**
 * @author Ronnie
 *
 */
public class AudioPlayer{

	private ArrayList<String> audioFiles;
	
	public AudioPlayer(String... files) {
		audioFiles = new ArrayList<String>();
		for(String file : files) {
			audioFiles.add("./res/" + file + ".wav");
		}
	}
	
	public void play() {
		try {
			System.out.println(audioFiles.get(0));
			File soundFile = new File(audioFiles.get(0));
			AudioInputStream audIn = AudioSystem.getAudioInputStream(soundFile);
			AudioFormat format = audIn.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip clip = (Clip) AudioSystem.getLine(info);
			clip.open(audIn);
			FloatControl gain = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gain.setValue(-10);
			clip.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
