package Models;

/**
 * Author: Hanna and Izabell
 * Uses: None
 * Used by: TimerViewModel gets information from this class
 * The modelclass for the timer part of the program. Contains functionality.
 */
public class TimerModel {
    /**
     * String that are used to get and set minutes
     */
    private String minutes;
    /**
     * String that are used to get and set seconds
     */
    private String seconds;
    /**
     * String that are used to get and set repetitions
     */
    private String reps;

    /**
     * Constructor for this class
     */
    public TimerModel() {
        this.minutes = "00";
        this.seconds = "00";
        this.reps = "0";
    }

    /**
     * Returns the right value of repetitions in a string form
     * @param repNumber The current value of repetitions
     */
    public void setReps(int repNumber) {
        this.reps = String.valueOf(repNumber);
    }

    /**
     * Returns the right value of minutes in a string form
     * @param min The current value of minutes
     */
    public void setMinutes(int min) {
        this.minutes =  String.valueOf(min);
    }

    /**
     * Returns the right value of seconds in a string form
     * @param sec The current value of seconds
     */
    public void setSeconds(int sec) {
        this.seconds = String.valueOf(sec);
    }

    /**
     * Gets the value of minutes
     * @return The value of minutes
     */
    public String getMinutes() {
        return minutes;
    }

    /**
     * Gets the value of seconds
     * @return The value of seconds
     */
    public String getSeconds() {
        return seconds;
    }

    /**
     * Gets the value of reps
     * @return The value of reps
     */
    public String getReps() {
        return reps;
    }

    /**
     * Makes sure that the timer has the format of a timer
     * @return The minutes and seconds separated with ":"
     */
    @Override
    public String toString() {
        return this.minutes + ":" + this.seconds;
    }

}