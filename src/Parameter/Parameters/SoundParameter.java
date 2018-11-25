package Parameter.Parameters;

public class SoundParameter extends AbstractParameter {

    public SoundParameter(boolean soundIsOn) {
        this.value = soundIsOn;
    }

    public static boolean getSoundFromString(String soundIsOn) {
        switch (soundIsOn) {
            case "TRUE":
                return true;
            case "FALSE":
                return false;
            default:
                throw new RuntimeException("The image : " + soundIsOn + " is unknown");
        }
    }

}
