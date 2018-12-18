package Utils.UI;

import Repository.Parameter.SoundParameterRepository;

import javax.sound.sampled.*;
import java.io.IOException;

public class SoundPlayer {
    public static void playSound(final String sound) {
        if ((boolean) SoundParameterRepository.getSound().getValue()) {
            try {
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(FileGetter.getSound(sound));
                DataLine.Info info = new DataLine.Info(Clip.class, inputStream.getFormat());
                Clip clip = (Clip) AudioSystem.getLine(info);
                clip.open(inputStream);
                clip.start();
            } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
                System.out.println(e);
            }
        }
    }
}
