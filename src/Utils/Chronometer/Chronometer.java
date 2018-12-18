package Utils.Chronometer;

public class Chronometer {
    private long startTime;

    /**
     * Create and start a chronometer
     */
    public Chronometer() {
        this.start();
    }

    /**
     * Start the chronometer
     */
    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    /**
     * Return the duration between the start time and the moment this method is called
     * The value returned is an int representing the time in seconds
     *
     * @return duration
     */
    public int getDuration() {
        return (int) ((System.currentTimeMillis() - this.startTime) / 1000);
    }
}
