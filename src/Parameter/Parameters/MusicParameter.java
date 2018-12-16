package Parameter.Parameters;

public class MusicParameter extends AbstractParameter {

    public MusicParameter(boolean musicIsOn) {
        this.value = musicIsOn;
    }

    public static boolean getMusicFromString(String musicIsOn) {
        switch (musicIsOn) {
            case "TRUE":
                return true;
            case "FALSE":
                return false;
            default:
                throw new RuntimeException("The music : " + musicIsOn + " is unknown");
        }
    }
}
