import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

/**
* PlayMidiAudio is a midi playing object
* Modified code from:
* http://examples.javacodegeeks.com/desktop-java/sound/play-midi-audio/
*
* @author Zack Sparks
* @version 1.0
*/
public class PlayMidiAudio {
	private Sequencer sequencer;

	/**
	* PlayMidiAudio constructor that plays the target midi upon being called.
	*/
	public PlayMidiAudio() throws Exception {

		// Obtains the default Sequencer connected to a default device.
		sequencer = MidiSystem.getSequencer();

		// Opens the device, indicating that it should now acquire any
		// system resources it requires and become operational.
		sequencer.open();

		// create a stream from a file
		InputStream is = new BufferedInputStream(new FileInputStream(
			new File("march.mid")));

		// Sets the current sequence on which the sequencer operates.
		// The stream must point to MIDI file data.
		sequencer.setSequence(is);

		play();
	}

	/**
	* Stops the midi file being played
	*/
	public void stop() throws Exception {
		// Stops playback of the MIDI data in the currently loaded sequence.
		sequencer.stop();

		// Closes the device, indicating that it should now acquire any
		// system resources it requires and become operational.
		sequencer.close();
	}

	private void play() throws Exception {

		// Starts playback of the MIDI data in the currently loaded sequence.
		sequencer.start();

	}

}
