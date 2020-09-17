package models;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;

public class Timer {

    @FXML private Spinner studyTimerSpinner, restTimerSpinner, repTimerSpinner;
    @FXML private Button startplanbutton, startTimerButton;

    private int studyTime;

    public void setStudyTime() {
        if (studyTime == 10 || studyTime == 20 || studyTime == 30) {
            this.studyTime = studyTime;
        }
        else {
            this.studyTime = 0;
        }
    }



}
