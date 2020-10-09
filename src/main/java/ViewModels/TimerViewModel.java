package ViewModels;

import ObserverInterfaces.TimerObservable;
import ObserverInterfaces.TimerObserver;
import Models.TimerModel;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import java.util.ArrayList;
import java.util.List;

public class TimerViewModel implements TimerObservable {

    private final List<TimerObserver> timerObservers = new ArrayList<>();

    public TimerModel timerModel = new TimerModel();

    public Timeline studyTimeline = new Timeline();
    public Timeline restTimeLine = new Timeline();

    private String labelType = "Studera";
    private int currentRep = 1;

    private int studyTime;
    private int restTime;
    private int repNumber;

    private int minutes;
    private int seconds;

    /*------------------------------------------Spinner methods-------------------------------------------------------*/

    public void setStudyTimeSpinner(Object studyTime) {
        this.studyTime = (int) studyTime;
        this.minutes = this.studyTime;
        this.seconds = 0;
        notifyObserver();
    }

    public void setRestTimerSpinner(Object restTime) {
        this.restTime = (int) restTime;
        this.seconds = 0;
        notifyObserver();
    }

    public void setRepTimerSpinner(Object repNumber) {
        this.repNumber = (int) repNumber;
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
        studyTimeline.playFromStart();
    }

    public void startRestTimer() {
        restTimeLine = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), e -> countDown()));
        restTimeLine.setCycleCount(Timeline.INDEFINITE);
        restTimeLine.playFromStart();
    }

    public void startTimer(Timeline timeline) {
        timeline = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), e -> countDown()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.playFromStart();
    }

    public void countDown() {
        if (seconds == 0 && minutes == 0) {
            timerOnGoing();
        }
        else if (seconds == 0) {
            minutes--;
            seconds = 59;
        }
        else {
            seconds--;
        }
        timerModel.setMinutes(minutes);
        timerModel.setSeconds(seconds);
        notifyObserver();
    }

    public void timerOnGoing() {
        if (studyTimeline.getStatus() == Animation.Status.RUNNING) {
            stopTimer(studyTimeline);
            setStudyTimeSpinner(restTime);
            labelType = "Vila";
            startRestTimer();
        }
        else if (restTimeLine.getStatus() == Animation.Status.RUNNING){
            stopTimer(restTimeLine);
            setStudyTimeSpinner(studyTime);
            labelType = "Studera";
            startStudyTimer();
            if(currentRep < repNumber) {
                currentRep++;
                notifyObserver();
            }
            else {
                stopTimer(studyTimeline);
            }
        }
    }

/*------------------------------------Observer pattern methods-------------------------------------------------------*/

    @Override
    public void register(TimerObserver timerObserver) {
        this.timerObservers.add(timerObserver);
    }

    @Override
    public void notifyObserver() {
        for(TimerObserver timerObserver : timerObservers) {
            timerObserver.update(studyTime, repNumber, labelType, currentRep);
            timerObserver.update(timerModel);
        }
    }
}