package Models;

/**
 * Author: Hanna and Iza
 * Uses:
 * Used by:
 * The modelclass for the timer part of the program. Contains much of the functionality.
 */
public class TimerModel {

    private String minutes;
    private String seconds;
    private String reps;

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
        this.reps = repNumber + "";
    }

    /**
     * Returns the right value of minutes in a string form
     * @param min The current value of minutes
     */
    public void setMinutes(int min) {
        if (min < 10) {
             this.minutes =  String.valueOf(min);
        } else {
            this.minutes = min + "";
        }
    }

    /**
     * Returns the right value of seconds in a string form
     * @param sec The current value of seconds
     */
    public void setSeconds(int sec) {
        if (sec < 10) {
            this.seconds = String.valueOf(sec);
        } else {
            this.seconds = sec + "";
        }
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
    public String toString() {
        return this.minutes + ":" + this.seconds;
    }

}