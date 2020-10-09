package ViewModels;

import javafx.animation.Animation;
import javafx.animation.Timeline;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimerViewModelTest {

    @Test
    public void pauseTimer() {
        Timeline timeline = new Timeline();
        timeline.playFromStart();
        TimerViewModel timerViewModel = new TimerViewModel();
        timerViewModel.pauseTimer(timeline);
        assertSame(timeline.getStatus(), Animation.Status.STOPPED); //Pauses time but stops evaluating
    }

    @Test
    void stopTimer() {
        Timeline timeline = new Timeline();
        timeline.play();
        TimerViewModel timerViewModel = new TimerViewModel();
        timerViewModel.stopTimer(timeline);
        assertSame(timeline.getStatus(), Animation.Status.STOPPED); //Stop the timer
    }

    @Test
    void startStudyTimer() {
        Timeline timeline = new Timeline();
        TimerViewModel timerViewModel = new TimerViewModel();
        startStudyTimer();
        timeline = timerViewModel.studyTimeline;
        assertSame(timeline.getStatus(), Animation.Status.RUNNING);
    }

    @Test
    void startRestTimer() {
        Timeline timeline = new Timeline();
        TimerViewModel timerViewModel = new TimerViewModel();
        //timerViewModel.startTimer(timerViewModel.restTimeLine);
        //timeline = timerViewModel.restTimeLine;
        assertSame(timeline.getStatus(), Animation.Status.RUNNING);
    }

    @Test
    void repNumberCountdown() {

    }

    @Test
    void countDown() {

    }

    @Test
    void register() {

    }

    @Test
    void notifyObserver() {

    }
}