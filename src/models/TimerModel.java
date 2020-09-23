package models;

import controllers.TimerController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.w3c.dom.Text;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class TimerModel {


    @FXML private Button startplanbutton, startTimerButton;
    @FXML private Label timerLabel;

    @FXML public Spinner studyTimerSpinner, restTimerSpinner, repTimerSpinner;



    private int studyTime;
    private int restTime;
    private int repTime;


    public void convertTimerInput(){
        studyTimerSpinner.getValue();

    }

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