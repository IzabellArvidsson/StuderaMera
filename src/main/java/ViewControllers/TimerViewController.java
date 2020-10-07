package ViewControllers;

import Factory.IPane;
import Models.TimerModel;
import ObserverInterfaces.TimerObserver;
import ViewModels.TimerViewModel;
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

public class TimerViewController extends AnchorPane implements IPane, Initializable, TimerObserver {

    @FXML private AnchorPane timerOnView, cancelPane, setTimerView;
    @FXML private Spinner<Integer> studyTimerSpinner, restTimerSpinner, repTimerSpinner;
    @FXML Label timerLabel, restTimerLabel, repTimerLabel, totalRepTimerLabel;

    private final TimerViewModel timerViewModel = new TimerViewModel();

    PaneController paneController = new PaneController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

/*-----------------------------------Register this class as an observer----------------------------------------------*/
        timerViewModel.register(this);

/*----------------------------------------Spinner initialize---------------------------------------------------------*/

        SpinnerValueFactory<Integer> studyFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 20, 5);
        this.studyTimerSpinner.setValueFactory(studyFactory);

        SpinnerValueFactory<Integer> restFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory( 1, 40, 5, 5);
        this.restTimerSpinner.setValueFactory(restFactory);

        SpinnerValueFactory<Integer> repFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1, 1);
        this.repTimerSpinner.setValueFactory(repFactory);
    }

    @FXML
    public void setStudyTime(){
        timerViewModel.setStudyTimeSpinner(studyTimerSpinner.getValue());
    }

    @FXML
    public void setRestTime() { timerViewModel.setRestTimerSpinner(restTimerSpinner.getValue()); }

    @FXML
    public void setRep() {
        timerViewModel.setRepTimerSpinner(repTimerSpinner.getValue());
    }

/*--------------------------------------------OnClick methods--------------------------------------------------------*/

    @FXML
    public void onClickStartTimer() {
        if (timerViewModel.studyTimeline != null) {
            timerViewModel.stopTimer(timerViewModel.studyTimeline);
        }
        timerViewModel.setStudyTimeSpinner(studyTimerSpinner.getValue());
        //timerViewModel.setRestTimerSpinner(restTimerSpinner.getValue());
        //timerViewModel.setRepTimerSpinner(repTimerSpinner.getValue());

        timerLabel.setText(timerViewModel.timerModel.toString());
        //restTimerLabel.setText(timerViewModel.timerModel.toString()); //Denna blir konstig
        //totalRepTimerLabel.setText(timerViewModel.timerModel.setRepNumber());

        timerViewModel.startStudyTimer();
        timerOnView.toFront();
    }

    public void onCLickStopButton() {
        timerViewModel.pauseTimer(timerViewModel.studyTimeline);
        cancelPane.toFront();
    }

    public void onCLickYesButton() {
        timerViewModel.stopTimer(timerViewModel.studyTimeline);
        setTimerView.toFront();
    }

    public void onClickNoButton() {
        timerViewModel.studyTimeline.play();
        timerOnView.toFront();
    }

    public void onClickGoToHelp(MouseEvent mouseEvent) throws IOException {
        paneController.showHelpPane();
    }

    public void onCLickGoToTips(MouseEvent mouseEvent) throws IOException {
        paneController.showTipsViewPane();
    }

    public void onClickStartPlanning(MouseEvent mouseEvent) throws IOException {
        paneController.showOverviewPane();
    }

    @FXML
    private void onClickStuderaMera(MouseEvent mouseEvent) throws IOException {
        paneController.showFirstViewPane();
    }

/*----------------------------------------Observer pattern methods---------------------------------------------------*/

    @Override
    public void update(int time) {
        timerLabel.setText(String.valueOf(time));
        //restTimerLabel.setText(String.valueOf(time));
    }

    @Override
    public void update(TimerModel timer) {
        timerLabel.setText(timer.toString());
        //restTimerLabel.setText(timer.toString());
    }


    @Override
    public void initPane(PaneController paneController) {
        this.paneController = paneController;
    }
}