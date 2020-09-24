package controllers;

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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.TimerModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TimerController extends AnchorPane implements Initializable {

    @FXML private AnchorPane timerOnView, cancelPane, setTimerView;



    private static Integer startTime;
    TimerModel timerModel = new TimerModel();

    @FXML public Spinner studyTimerSpinner, restTimerSpinner, repTimerSpinner;
    @FXML Button startTimerButton, stopTimerButton;
    @FXML Label timerLabel;
    private Timeline timeline;
    private final IntegerProperty seconds = new SimpleIntegerProperty();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        timerLabel.textProperty().bind(seconds.asString());
        startTimerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(timeline != null){
                    timeline.stop();
                }
                startTime = (Integer) studyTimerSpinner.getValue();
                seconds.set(startTime);
                timeline = new Timeline();
                timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(startTime+1), new KeyValue(seconds,0)));
                timeline.playFromStart();
            }
        });

        SpinnerValueFactory<Integer> studyFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 100, 20, 5);
        this.studyTimerSpinner.setValueFactory(studyFactory);
        studyTimerSpinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer newValue) {
                timerModel.setStudyTimeSpinner(newValue);
                System.out.println(newValue);
            }
        });

        SpinnerValueFactory<Integer> restFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 40, 5, 5);
        this.restTimerSpinner.setValueFactory(restFactory);
        restTimerSpinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer newValue) {
                timerModel.setRestTimerSpinner(newValue);
            }
        });

        SpinnerValueFactory<Integer> repFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1, 1);
        this.repTimerSpinner.setValueFactory(repFactory);
        repTimerSpinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer newValue) {
                timerModel.setRepTimerSpinner(newValue);
            }
        });
    }

    public void onClickStartTimer () {
        timerOnView.toFront();
    }

    public void onCLickStopButton () {
        timeline.pause();
        timerOnView.toFront();
        cancelPane.toFront();
    }

    public void onCLickYesButton () {
        setTimerView.toFront();
    }

    public void onClickNoButton () {
        timeline.play();
        timerOnView.toFront();
    }

    public void onClickGoToHelp (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent timerViewParent = FXMLLoader.load(getClass().getResource("/fxml_files/HelpView.fxml"));
        Scene timerViewScene = new Scene(timerViewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(timerViewScene);
        window.show();
    }

    public void onCLickGoToTips (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent timerViewParent = FXMLLoader.load(getClass().getResource("/fxml_files/TipsView.fxml"));
        Scene timerViewScene = new Scene(timerViewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(timerViewScene);
        window.show();
    }

    public void onClickStartPlanning (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent timerViewParent = FXMLLoader.load(getClass().getResource("/fxml_files/PlanOverview.fxml"));
        Scene timerViewScene = new Scene(timerViewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(timerViewScene);
        window.show();
    }

    @FXML
    private void onClickStuderaMera (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent timerViewParent = FXMLLoader.load(getClass().getResource("/fxml_files/firstSideView.fxml"));
        Scene timerViewScene = new Scene(timerViewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(timerViewScene);
        window.show();
    }

}