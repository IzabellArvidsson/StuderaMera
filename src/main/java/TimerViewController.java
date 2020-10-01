import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TimerViewController extends AnchorPane implements Initializable, TimerObserver {

    @FXML private AnchorPane timerOnView, cancelPane, setTimerView;
    @FXML private Spinner<Integer> studyTimerSpinner, restTimerSpinner, repTimerSpinner;
    @FXML Label timerLabel, restTimerLabel;

    private final TimerViewModel timerModel = new TimerViewModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

/*-----------------------------------Register this class as an observer----------------------------------------------*/
        timerModel.register(this);

/*----------------------------------------Spinner initialize---------------------------------------------------------*/

        SpinnerValueFactory<Integer> studyFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 100, 20, 5);
        this.studyTimerSpinner.setValueFactory(studyFactory);

        SpinnerValueFactory<Integer> restFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 40, 5, 5);
        this.restTimerSpinner.setValueFactory(restFactory);

        SpinnerValueFactory<Integer> repFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1, 1);
        this.repTimerSpinner.setValueFactory(repFactory);
    }

    @FXML
    public void setStudyTime(){
        timerModel.setStudyTimeSpinner(studyTimerSpinner.getValue());
    }

    @FXML
    public void setRestTime() { timerModel.setRestTimerSpinner(restTimerSpinner.getValue()); }

/*--------------------------------------------OnClick methods--------------------------------------------------------*/

    @FXML
    public void onClickStartTimer() {
        if (timerModel.studyTimeline != null) {
            timerModel.stopTimer();
        }
        timerLabel.setText(timerModel.timer.toString());
        timerModel.startStudyTimer();
        timerOnView.toFront();
    }

    public void onCLickStopButton() {
        timerModel.pauseTimer();
        timerOnView.toFront();
        cancelPane.toFront();
    }

    public void onCLickYesButton() {
        setTimerView.toFront();
    }

    public void onClickNoButton() {
        timerModel.studyTimeline.play();
        timerOnView.toFront();
    }

    public void onClickGoToHelp(MouseEvent mouseEvent) throws IOException {
        Parent timerViewParent = FXMLLoader.load(getClass().getResource("/fxml_files/HelpView.fxml"));
        Scene timerViewScene = new Scene(timerViewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(timerViewScene);
        window.show();
    }

    public void onCLickGoToTips(MouseEvent mouseEvent) throws IOException {
        Parent timerViewParent = FXMLLoader.load(getClass().getResource("/fxml_files/TipsView.fxml"));
        Scene timerViewScene = new Scene(timerViewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(timerViewScene);
        window.show();
    }

    public void onClickStartPlanning(MouseEvent mouseEvent) throws IOException {
        Parent timerViewParent = FXMLLoader.load(getClass().getResource("/fxml_files/PlanOverview.fxml"));
        Scene timerViewScene = new Scene(timerViewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(timerViewScene);
        window.show();
    }

    @FXML
    private void onClickStuderaMera(MouseEvent mouseEvent) throws IOException {
        Parent timerViewParent = FXMLLoader.load(getClass().getResource("/fxml_files/firstSideView.fxml"));
        Scene timerViewScene = new Scene(timerViewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(timerViewScene);
        window.show();
    }

/*----------------------------------------Observer pattern methods---------------------------------------------------*/

    @Override
    public void update(int time) {
        timerLabel.setText(String.valueOf(time));
    }

    @Override
    public void update(Timer timer) {
        timerLabel.setText(timer.toString());
    }
}