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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TimerController extends AnchorPane implements Initializable, TimerObserver {

    @FXML private AnchorPane timerOnView, cancelPane, setTimerView;
    @FXML private Spinner studyTimerSpinner, restTimerSpinner, repTimerSpinner;
    @FXML private Button startTimerButton, stopTimerButton;
    @FXML Label timerLabel;

    private TimerModel timerModel = new TimerModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

/*-----------------------------------Register this class ass an observer---------------------------------------------*/

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
    public void onClickStartTimer() {
        timerLabel.textProperty().bind(timerModel.seconds.asString());
        if (timerModel.timeline != null) {
            timerModel.stopTimer();
        }
        timerModel.startTimer();
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
        timerModel.timeline.play();
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

    @FXML
    public void setStudyTime(){
        timerModel.setStudyTimeSpinner(studyTimerSpinner.getValue());
    }

/*----------------------------------------Observer pattern methods---------------------------------------------------*/

    @Override
    public void update(int time) {
        try {
            timerLabel.setText(String.valueOf(time));
        } catch (Exception e){
            System.out.println(e);
        }
    }

}