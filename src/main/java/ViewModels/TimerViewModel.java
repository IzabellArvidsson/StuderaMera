package ViewModels;

import Interfaces.ITimerViewModel;
import ObserverInterfaces.TimerObservable;
import ObserverInterfaces.TimerObserver;
import Models.TimerModel;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Hanna and Izabell
 * Uses:
 * Used by:
 * Handles the timer functionalities
 */
public class TimerViewModel implements TimerObservable, ITimerViewModel {

    private final List<TimerObserver> timerObservers = new ArrayList<>();

    public TimerModel timerModel = new TimerModel();

    public Timeline studyTimeline = new Timeline();
    public Timeline restTimeLine = new Timeline();

    private String labelType = "Studera";
    private int currentRep = 1;

    public int countUp;

    private boolean stopped = false;

    private int studyTime;
    private int restTime;
    private int repNumber;

    private int minutes;
    private int seconds;

    /*------------------------------------------Spinner methods-------------------------------------------------------*/

    /**
     * Sets the timelines to their values
     */
    public void setTimelines() {
        studyTimeline = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), e -> countDown(studyTimeline)));
        restTimeLine = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), e -> countDown(restTimeLine)));
    }

    /**
     * Takes in a value of the studytimerspinner and sets minutes and seconds to the right values
     * @param studyTime The value of the studytimerspinner from controller
     */
    public void setStudyTimerSpinner(Object studyTime) {
        this.studyTime = (int) studyTime;
        this.minutes = this.studyTime;
        this.seconds = 0;
        notifyObserver();
    }

    /**
     * Takes in a value of the resttimerspinner and sets minutes and seconds to the right values
     * @param restTime The value of the resttimerspinner from controller
     */
    public void setRestTimerSpinner(Object restTime) {
        this.restTime = (int) restTime;
        this.seconds = 0;
        notifyObserver();
    }

    /**
     * Takes in a value of the reptimerspinner and the total repetitions and the "first" current repetitiion
     * to the right values
     * @param repNumber The value of the reptimerspinner from controller
     */
    public void setRepTimerSpinner(Object repNumber) {
        this.repNumber = (int) repNumber;
        currentRep = 1;
        notifyObserver();
    }

    /**
     * Sets the value of countUp to 0 so that it always begins on that value when you start the timer
     */
    public void setCountUpInt() {
        countUp = 0;
    }

    /*------------------------------------------Timer methods---------------------------------------------------------*/

    /**
     * Starts the timer with the studytimeline
     */
    @Override
    public void startStudyTime() {
        startTimer(studyTimeline);
    }

    /**
     * Pauses the timer with the studytimeline
     */
    @Override
    public void pauseStudyTime() {
        pauseTimer(studyTimeline);
    }

    /**
     * Stops the timer with the studytimeline
     */
    @Override
    public void stopStudyTime() {
        stopTimer(studyTimeline);
    }

    /**
     * Plays the timer with the studytimeline
     */
    @Override
    public void playStudyTime() {
        playTimer(studyTimeline);
    }

    /**
     * Pauses the timer
     * @param timeLine Which timeline that is supposed to be paused
     */
    public void pauseTimer(Timeline timeLine) {
        timeLine.pause();
    }

    /**
     * Stops the timer
     * @param timeline Which timeline that i supposed to be stopped
     */
    public void stopTimer(Timeline timeline) {
        timeline.stop();
    }

    public void playTimer(Timeline timeline) {
        timeline.play();
    }

    /**
     * Sets the cycle of the timer to indefinite and starts the timer
     * @param timeline The timeline which is supposed to start
     */
    public void startTimer(Timeline timeline) {
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.playFromStart();
    }

    /**
     * Checks the minutes and seconds and changes the value depending on what those values are. Sends the new values to
     * be set in TimerModel
     * @param timeline Which timeline that is supposed to count down
     */
    protected void countDown(Timeline timeline) {
        checkIfStudyTimeIsRunning(timeline);
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
        timerModel.setReps(repNumber);
        notifyObserver();
    }

    /**
     * Checks if it's the studytimeline that is running and if it is, the countUp ads 1 to to itself
     * @param timeline The timeline that is supposed to be used
     */
    protected void checkIfStudyTimeIsRunning(Timeline timeline) {
        if (timeline.getStatus() == Animation.Status.RUNNING && timeline == studyTimeline) {
            countUp++;
        }
    }

    /**
     * Checks which timeline that i running
     */
    protected void timerOnGoing() {
        if (studyTimeline.getStatus() == Animation.Status.RUNNING) {
            studyTimeIsRunning();
        }
        else if (restTimeLine.getStatus() == Animation.Status.RUNNING){
            restTimeIsRunning();
        }
    }

    /**
     * Checks if the timer is done or if it isn't. Then doing some tasks depending on the result
     */
    protected void studyTimeIsRunning() {
        if(currentRep == repNumber) {
            stopTimer(studyTimeline);
            stopped = true;
            notifyObserver();
            stopped = false;
        }
        else {
            stopTimer(studyTimeline);
            labelType = "Vila";
            setStudyTimerSpinner(restTime);
            startTimer(restTimeLine);
        }
    }

    /**
     * Switches back to studytimeline and adding 1 to the current repetitions
     */
    protected void restTimeIsRunning() {
        stopTimer(restTimeLine);
        setStudyTimerSpinner(studyTime);
        labelType = "Studera";
        startTimer(studyTimeline);
        if(currentRep < repNumber) {
            currentRep++;
            notifyObserver();
        }
        else {
            stopTimer(studyTimeline);
        }
    }

    /*------------------------------------Observer pattern methods---------------------------------------------------*/

    /**
     * Adds observers to a list
     * @param timerObserver The observer that i supposed to de added
     */
    @Override
    public void register(TimerObserver timerObserver) {
        this.timerObservers.add(timerObserver);
    }

    /**
     * The method that notifies the observers that an update has happened and needs to be taken care of
     */
    @Override
    public void notifyObserver() {
        for(TimerObserver timerObserver : timerObservers) {
            timerObserver.update(repNumber, labelType, currentRep, stopped, countUp);

            String time = timerModel.toString();
            timerObserver.update(time);
        }
    }
}