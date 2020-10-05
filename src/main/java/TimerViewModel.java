import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class TimerViewModel implements TimerObservable {

    private final List<TimerObserver> timerObservers = new ArrayList<>();

    public final Timer timer = new Timer();

    public Timeline studyTimeline = new Timeline();
    public Timeline restTimeLine = new Timeline();

    private int studyTime = 20;
    private int restTime;
    private int repNumber;

    private int minutes = 20;
    private int seconds= 0;

    /*------------------------------------------Spinner methods----------------------------------------------------------*/

    public void setStudyTimeSpinner(Object studyTime) {
        this.studyTime = minutes;
        notifyObserver();
    }

    public void setRestTimerSpinner(Object restTime) {
        this.restTime = minutes;
        notifyObserver();
    }

    public void setRepTimerSpinner(Object repNumber) {
        this.repNumber = (int) repNumber;
        notifyObserver();
    }

/*------------------------------------------Timer methods------------------------------------------------------------*/

    public void pauseTimer() {
        studyTimeline.pause();
    }

    public void stopTimer() {
        studyTimeline.stop();
    }

    public void startStudyTimer() {
        studyTimeline = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), e -> countDown()));
        studyTimeline.setCycleCount(Timeline.INDEFINITE);
        studyTimeline.play();
    }

    public void startRestTimer() {
        restTimeLine = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), e -> countDown()));
        restTimeLine.setCycleCount(Timeline.INDEFINITE);
        restTimeLine.play();
    }

    public void countDown() {
        if (seconds == 0) {
            minutes--;
            seconds = 59;
        } else {
            seconds--;
        }
        timer.setMinutes(minutes);
        timer.setSeconds(seconds);
        notifyObserver();
    }

/*------------------------------------Observer pattern methods-------------------------------------------------------*/

    @Override
    public void register(TimerObserver timerObserver) {
        this.timerObservers.add(timerObserver);
    }

    @Override
    public void notifyObserver() {
        for(TimerObserver timerObserver : timerObservers) {
            timerObserver.update(studyTime);
            timerObserver.update(timer);
        }
        if(studyTimeline == null) {
            startRestTimer();
        }
    }
}