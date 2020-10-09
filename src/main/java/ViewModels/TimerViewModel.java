package ViewModels;

import ObserverInterfaces.TimerObservable;
import ObserverInterfaces.TimerObserver;
import Models.TimerModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import java.util.ArrayList;
import java.util.List;

public class TimerViewModel implements TimerObservable {

    private final List<TimerObserver> timerObservers = new ArrayList<>();

    public TimerModel timerModel = new TimerModel();

    public Timeline studyTimeline = new Timeline();
    public Timeline restTimeLine = new Timeline();

    private int studyTime;
    private int restTime;
    private int repNumber;

    private int minutes;
    private int seconds;
    private int reps;

    /*------------------------------------------Spinner methods-------------------------------------------------------*/

    public void setStudyTimeSpinner(Object studyTime) {
        this.studyTime = (int) studyTime;
        this.minutes = this.studyTime;
        notifyObserver();
    }

    public void setRestTimerSpinner(Object restTime) {
        this.restTime = (int) restTime;
        this.minutes = this.restTime;
        notifyObserver();
    }

    public void setRepTimerSpinner(Object repNumber) {
        this.repNumber = (int) repNumber;
        this.reps = this.repNumber;
        notifyObserver();
    }

/*------------------------------------------Timer methods------------------------------------------------------------*/

    public void pauseTimer(Timeline timeLine) {
        timeLine.pause();
    }

    public void stopTimer(Timeline timeline) {
        timeline.stop();
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

    public void repNumberCountdown() {
        if(repNumber != 0) {
            repNumber--;
        }
    }

    public void countDown() {
        if (seconds == 0) {
           this.minutes--;
            seconds = 59;
        }
        /*else if (minutes == 0 && seconds == 0){
            repNumberCountdown();
        }*/
        else {
            seconds--;
        }
        timerModel.setMinutes(this.minutes);
        timerModel.setSeconds(seconds);
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
           // timerObserver.update(restTime);
            timerObserver.update(timerModel);
        }
    }
}