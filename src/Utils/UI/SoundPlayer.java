package Utils.UI;

import Repository.Parameter.SoundParameterRepository;

import javax.sound.sampled.*;

public class SoundPlayer {
    public static void playSound(final String sound) {
        if ((boolean) SoundParameterRepository.getSound().getValue()) {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(FileGetter.getSound(sound)));
                clip.start();
            } catch (Exception exc) {
                exc.printStackTrace(System.out);
            }
        }
    }
}
