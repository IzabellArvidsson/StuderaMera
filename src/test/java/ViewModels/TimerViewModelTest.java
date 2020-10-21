package ViewModels;

import Models.TimerModel;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TimerViewModelTest {

    @Test
    void testStartStudyTime() {
        TimerViewModel timerViewModel = new TimerViewModel();
        timerViewModel.setTimelines();
        //timerViewModel.studyTimeline.stop();
        timerViewModel.startStudyTime();

        assertEquals(Animation.Status.RUNNING, timerViewModel.studyTimeline.getStatus());
    }

    @Test
    public void testPauseTimer() {
        Timeline timeline = new Timeline();
        timeline.playFromStart();
        TimerViewModel timerViewModel = new TimerViewModel();
        timerViewModel.pauseTimer(timeline);

        assertSame(timeline.getStatus(), Animation.Status.STOPPED);
    }

    @Test
    void testStopTimer() {
        Timeline timeline = new Timeline();
        timeline.play();
        TimerViewModel timerViewModel = new TimerViewModel();
        timerViewModel.stopTimer(timeline);

        assertSame(timeline.getStatus(), Animation.Status.STOPPED);
    }

    @Test
    void testStartTimer() {
        TimerViewModel timerViewModel = new TimerViewModel();
        Timeline timeline = new Timeline();
        Timeline finalTimeline = timeline;
        timeline = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), e -> timerViewModel.countDown(finalTimeline)));
        timerViewModel.startTimer(timeline);
        assertSame(timeline.getStatus(), Animation.Status.RUNNING);
    }

    @Test
    void testCountDown() {
        TimerViewModel timerViewModel = new TimerViewModel();
        TimerModel timerModel = new TimerModel();
        timerModel.setMinutes(3);
        timerModel.setSeconds(0);

        int minutes = 3;
        timerViewModel.setStudyTimerSpinner(minutes);
        Timeline timeline = new Timeline();
        Timeline finalTimeline = timeline;
        timeline = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), e -> timerViewModel.countDown(finalTimeline)));

        timerViewModel.countDown(timeline);

        assertEquals(2, Integer.parseInt(timerViewModel.timerModel.getMinutes()));
        assertEquals(59, Integer.parseInt(timerViewModel.timerModel.getSeconds()));
    }

    @Test
    void testCheckIfStudyTimeIsRunning() {
        TimerViewModel timerViewModel = new TimerViewModel();
        timerViewModel.setTimelines();
        timerViewModel.studyTimeline.playFromStart();
        timerViewModel.checkIfStudyTimeIsRunning(timerViewModel.studyTimeline);

        assertEquals(1, timerViewModel.countUp);
    }

    @Test
    void testTimerOnGoing() {
        TimerViewModel timerViewModel = new TimerViewModel();
        timerViewModel.setTimelines();
        timerViewModel.studyTimeline.playFromStart();
        timerViewModel.timerOnGoing();

        assertEquals(Animation.Status.STOPPED, timerViewModel.studyTimeline.getStatus());
    }

    @Test
    void testStudyTimeIsRunning() {
        TimerViewModel timerViewModel = new TimerViewModel();
        timerViewModel.setTimelines();
        timerViewModel.studyTimeline.playFromStart();

        timerViewModel.studyTimeIsRunning();

        assertEquals(Animation.Status.STOPPED, timerViewModel.studyTimeline.getStatus());
    }

    @Test
    void testRestTimeIsRunning() {
        TimerViewModel timerViewModel = new TimerViewModel();
        timerViewModel.setTimelines();
        timerViewModel.restTimeLine.playFromStart();

        timerViewModel.restTimeIsRunning();

        assertEquals(Animation.Status.STOPPED, timerViewModel.restTimeLine.getStatus());
    }
}