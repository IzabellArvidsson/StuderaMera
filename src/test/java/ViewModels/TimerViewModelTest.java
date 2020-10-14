package ViewModels;

import Models.ImageModel;
import Models.TimerModel;
import ObserverInterfaces.TimerObserver;
import ViewControllers.TimerViewController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TimerViewModelTest {

    @Test
    public void testPauseTimer() {
        Timeline timeline = new Timeline();
        timeline.playFromStart();
        TimerViewModel timerViewModel = new TimerViewModel();
        timerViewModel.pauseTimer(timeline);
        assertSame(timeline.getStatus(), Animation.Status.STOPPED); //Pauses time but stops evaluating
    }

    @Test
    void testStopTimer() {
        Timeline timeline = new Timeline();
        timeline.play();
        TimerViewModel timerViewModel = new TimerViewModel();
        timerViewModel.stopTimer(timeline);
        assertSame(timeline.getStatus(), Animation.Status.STOPPED); //Stop the timer
    }

    @Test
    void testStartTimer() {
        Timeline timeline = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), e -> countDown()));
        TimerViewModel timerViewModel = new TimerViewModel();
        timerViewModel.startTimer(timeline);
        assertSame(timeline.getStatus(), Animation.Status.RUNNING);
    }

    @Test
    void countDown() {
        TimerViewModel timerViewModel = new TimerViewModel();
        Timeline timeline = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), e -> countDown()));
        timerViewModel.countDown(timeline);


    }

    @Test
    void testCheckIfStudyTimeIsRunning() {
        TimerViewModel timerViewModel = new TimerViewModel();
        ImageModel imageModel = new ImageModel();
        timerViewModel.setTimelines();
        timerViewModel.studyTimeline.playFromStart();

        timerViewModel.checkIfStudyTimeIsRunning(timerViewModel.studyTimeline);

        assertEquals(1, imageModel.countUp);
    }

    @Test
    void testTimerOnGoing() {
        TimerViewModel timerViewModel = new TimerViewModel();
        timerViewModel.studyTimeline.playFromStart();
        timerViewModel.timerOnGoing();

    }

    @Test
    void studyTimeIsRunning() {
    }

    @Test
    void restTimeIsRunning() {
    }

    @Test
    void register() {
        TimerViewModel timerViewModel = new TimerViewModel();
        List<TimerObserver> timerObservers = new ArrayList<>();
        TimerObserver timerObserver = new TimerObserver() {
            @Override
            public void update(int time, int reps, String string, int currentRep, boolean stopped, int countUp) {

            }

            @Override
            public void update(TimerModel timer) {

            }
        };
        timerViewModel.register(timerObserver);

        assertEquals(1, timerObservers.size());

    }

    @Test
    void testNotifyObserver() {

    }
}