package Models;



public class TimerModel {
    private String minutes;
    private String seconds;
    private String reps;
    public TimerModel() {
        minutes = "00";
        this.seconds = "00";
        this.reps = "0";
    }
    public String getMinutes() {
        return this.minutes;
    }
    public String getSeconds() {
        return this.seconds;
    }

    public void setMinutes(int min) {
        if (min < 10) {
            this.minutes =  String.valueOf(min);
        } else {
            this.minutes = min + "";
        }
    }
    public void setSeconds(int sec) {
        if (sec < 10) {
            this.seconds = String.valueOf(sec);
        } else {
            this.seconds = sec + "";
        }
    }
    public String stringOf() { return this.reps; }
    public String toString() {
        return this.minutes + ":" + this.seconds;
    }
}