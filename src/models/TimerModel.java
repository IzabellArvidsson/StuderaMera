package models;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import org.w3c.dom.Text;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

public class TimerModel {

    @FXML private Spinner studyTimerSpinner, restTimerSpinner, repTimerSpinner;
    @FXML private Button startplanbutton, startTimerButton;
    @FXML private Label timerLabel;

    private int studyTime;
    private int restTime;
    private int repTime;

    public void setStudyTimeSpinner(int studyTime) {
        if(studyTime>0 && studyTime<=100){
            this.studyTime = studyTime;
        }
    }

    public void setRestTimerSpinner(int restTime) {
        if(restTime>0 && restTime<= 40){
            this.restTime = restTime;
        }
    }

    public void setRepTimerSpinner(int repTime) {
        if(repTime> 0 && repTime<=10)
            this.repTime = repTime;
    }
}