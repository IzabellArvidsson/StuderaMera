package ViewModels;

import Models.TimerModel;
import ObserverInterfaces.TimerObserver;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

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
        Timeline timeline;
        TimerViewModel timerViewModel = new TimerViewModel();
        timerViewModel.startStudyTimer();
        timeline = timerViewModel.studyTimeline;
        assertSame(timeline.getStatus(), Animation.Status.RUNNING);
    }

    @Test
    void startRestTimer() {
        Timeline timeline;
        TimerViewModel timerViewModel = new TimerViewModel();
        timerViewModel.startRestTimer();
        timeline = timerViewModel.restTimeLine;
        assertSame(timeline.getStatus(), Animation.Status.RUNNING);
    }

    @Test
    void countDown() {

    }

    @Test
    void register() {
        TimerViewModel timerViewModel = new TimerViewModel();
        final List<TimerObserver> timerObservers = new ArrayList<>();
        TimerObserver timerObserver = null;

        timerViewModel.register(timerObserver);

       // assertEquals(1, timerObservers.size());

    }

    @Test
    void notifyObserver() {

    }
}