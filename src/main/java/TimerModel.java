import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TimerModel implements TimerObservable {

    private List<TimerObserver> timerObservers = new ArrayList<TimerObserver>();

    public Timeline timeline = new Timeline();

    public final IntegerProperty seconds = new SimpleIntegerProperty();

    private int studyTime = 20;
    private int restTime;
    private int repTime;

/*------------------------------------------Spinnermethods-----------------------------------------------------------*/

    public void setStudyTimeSpinner(Object studyTime) {
        this.studyTime= (int) studyTime;
        notifyObserver();
    }

    public void setRestTimerSpinner(int restTime) {
        this.restTime = restTime;
    }

    public void setRepTimerSpinner(int repTime) {
        this.repTime = repTime;
    }

/*------------------------------------------Timermethods-------------------------------------------------------------*/

    public void pauseTimer() {
        timeline.pause();
    }

    public void stopTimer() {
        timeline.stop();
    }

    public void startTimer() {
        int startTime = studyTime;
        seconds.set(startTime);
        timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(startTime +1), new KeyValue(seconds,0)));
        timeline.playFromStart();
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
        }
    }
}