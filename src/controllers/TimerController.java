package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TimerController extends AnchorPane implements Initializable {

    @FXML private AnchorPane timerOnView, cancelPane, popupPane, setTimerView;
    @FXML private Spinner studyTimerSpinner, restTimerSpinner, repTimerSpinner;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpinnerValueFactory<Integer> studyFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 100, 20, 5);
        this.studyTimerSpinner.setValueFactory(studyFactory);

        SpinnerValueFactory<Integer> restFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 40, 5, 5);
        this.restTimerSpinner.setValueFactory(restFactory);

        SpinnerValueFactory<Integer> repFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1, 1);
        this.repTimerSpinner.setValueFactory(repFactory);

    }

    public void onClickStartTimer () {
        timerOnView.toFront();
    }

    public void onCLickStopButton () {
        popupPane.toFront();
        cancelPane.toFront();
    }

    public void onCLickYesButton () {
        setTimerView.toFront();
    }

    public void onClickNoButton () {
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