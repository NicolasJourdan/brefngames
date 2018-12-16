package Utils.Music;

import javax.sound.sampled.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MusicManager {

    static MusicManager instance;

    private final static String MUSIC_LIBRARY_PATH = "/data/Musics/";
    private Clip clip;
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
        this.musicList.add(this.getSound("Zelda-OOT-Shop.wav"));
        this.musicList.add(this.getSound("Zelda-Wind-Waker-Dragon-Roost-Island.wav"));
        this.musicList.add(this.getSound("Zelda-Wind-Waker-Outset-Island.wav"));
        this.lastMusic = null;
    }

    public void start() {
        this.playNextSound();
    }

    public void stop() {
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
            this.clip = AudioSystem.getClip();

            this.clip.open(AudioSystem.getAudioInputStream(this.getNextSound()));
            this.clip.start();

            this.clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (LineEvent.Type.STOP == event.getType()) {
                        MusicManager.this.clip.stop();
                        MusicManager.this.playNextSound();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
