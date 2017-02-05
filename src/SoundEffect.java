import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

     
public class SoundEffect {

	private Clip clip;
	
	public SoundEffect(String soundFileName) {
	      try {
	        // URL url = this.getClass().getResource(soundFileName);
	    	  File file = new File("resources/"+soundFileName);
	         System.out.println();
	         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
	        // AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(soundFileName) );
	         // Get a clip resource.
	         clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioInputStream);
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	}
	
	public void play() {
		if (clip.isRunning())
			clip.stop();   // Stop the player if it is still running
		clip.setFramePosition(0); // rewind to the beginning
		clip.start();     // Start playing
		//if(loop)//Loop if loop parameter is true
			//clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}
