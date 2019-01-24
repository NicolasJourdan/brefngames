package Utils.Music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MusicManager {

    static MusicManager instance;

    // set the gain (between 0.0 and 1.0)
    private static final double GAIN = 0.15;
    private static final double VOLUME_PERCENT = 0.25;
    private final static String MUSIC_LIBRARY_PATH = "/data/Musics/";

    private Clip clip;
    private LineListener lineListener;
    private List<File> musicList;
    private File lastMusic;

    /**
     * Singleton here
     *
     * @return
     */
    public static MusicManager getInstance() {
        if (null == MusicManager.instance) {
            MusicManager.instance = new MusicManager();
        }

        return MusicManager.instance;
    }

    private MusicManager() {
        this.musicList = new ArrayList<>();
        this.musicList.add(this.getSound("Humble-Match.wav"));
        this.musicList.add(this.getSound("Prorroga-de-Tiempo-C.wav"));
        this.musicList.add(this.getSound("Solve-The-Puzzle.wav"));
        this.musicList.add(this.getSound("Su-Turno.wav"));
        this.lastMusic = null;
    }

    public void start() {
        this.playNextSound();
    }

    public void stop() {
        // the music can't be stopped if no clip exist
        if (null == this.clip) {
            return;
        }

        this.clip.removeLineListener(this.lineListener);
        this.clip.stop();
        System.out.println("MusicManager: stop playing");
    }

    /**
     * Get a sound from the Music library
     *
     * @param sound
     * @return
     */
    private File getSound(String sound) {
        return new File("src" + MusicManager.MUSIC_LIBRARY_PATH + sound);
    }

    /**
     * Get a random new song different from the last played one
     *
     * @return
     */
    private File getNextSound() {
        Random random = new Random();
        File sound = null;

        while (null == sound || sound.equals(this.lastMusic)) {
            sound = this.musicList.get(random.nextInt(this.musicList.size()));
        }

        this.lastMusic = sound;
        System.out.println("MusicManager: playing " + this.lastMusic.getName());
        return this.lastMusic;
    }

    /**
     * Play the next sound
     */
    private void playNextSound() {
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(this.getNextSound());
            DataLine.Info info = new DataLine.Info(Clip.class, inputStream.getFormat());
            this.clip = (Clip) AudioSystem.getLine(info);
            this.clip.open(inputStream);

            try {
                FloatControl gainControl = (FloatControl) this.clip.getControl(FloatControl.Type.MASTER_GAIN);
                float dB = (float) (Math.log(MusicManager.GAIN) / Math.log(10.0) * 20.0);
                gainControl.setValue(dB);
            }
            catch (IllegalArgumentException masterGainException) {
                System.out.println("Could not change the gain, trying with volume");
                try {
                    FloatControl volumeControl = (FloatControl) this.clip.getControl(FloatControl.Type.VOLUME);
                    volumeControl.setValue(
                            (float) (volumeControl.getMaximum() * MusicManager.VOLUME_PERCENT)
                    );
                }
                catch (IllegalArgumentException volumeException) {
                    System.out.println("Neither volume nor gain could be changed");
                }
            }
            this.clip.start();

            this.lineListener = new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (LineEvent.Type.STOP == event.getType()) {
                        MusicManager.this.clip.stop();
                        MusicManager.this.playNextSound();
                    }
                }
            };

            this.clip.addLineListener(this.lineListener);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace(System.out);
        }
    }
}
