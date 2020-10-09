package ViewControllers;

import Models.TimerModel;
import ObserverInterfaces.TimerObserver;
import ViewModels.TimerViewModel;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TimerViewController extends AnchorPane implements Initializable, TimerObserver {

    @FXML private AnchorPane timerOnView, cancelPane, setTimerView, popupPane, failPane;
    @FXML private Spinner<Integer> studyTimerSpinner, restTimerSpinner, repTimerSpinner;
    @FXML Label timerLabel, repTimerLabel, totalRepTimerLabel, typeOfTimerLabel;
    @FXML ImageView flowerChangingImage;

    private final TimerViewModel timerViewModel = new TimerViewModel();

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

    public void anchorPaneChange() {
        popupPane.toFront();
        popupPane.toBack();
    }

    public void imageLoader() {
        int totalTime = studyTimerSpinner.getValue() * repTimerSpinner.getValue();
        int divideTotalTime = totalTime / repTimerSpinner.getValue();

        if(timerLabel.getText().equals(String.valueOf(divideTotalTime))) {
            flowerChangingImage.getClass().getResource("/images/flower/plant_1.png");
        }
        else if(timerLabel.getText().equals(String.valueOf(2*divideTotalTime))) {
            flowerChangingImage.getClass().getResource("/images/flower/plant_2.png");
        }
        else if(timerLabel.getText().equals(String.valueOf(3*divideTotalTime))) {
            flowerChangingImage.getClass().getResource("/images/flower/plant_3.png");
        }
        else if(timerLabel.getText().equals(String.valueOf(4*divideTotalTime))) {
            flowerChangingImage.getClass().getResource("/images/flower/plant_4.png");
        }
        else if(timerLabel.getText().equals(String.valueOf(5*divideTotalTime))) {
            flowerChangingImage.getClass().getResource("/images/flower/plant_5.png");
        }
        else if(timerLabel.getText().equals(String.valueOf(6*divideTotalTime))) {
            flowerChangingImage.getClass().getResource("/images/flower/plant_6.png");
        }
        else if(timerLabel.getText().equals(String.valueOf(7*divideTotalTime))) {
            flowerChangingImage.getClass().getResource("/images/flower/plant_7_done.png");
        }
    }

/*--------------------------------------------OnClick methods--------------------------------------------------------*/

    /**
     * This method gets the value of the spinners and makes sure that the right values are written to the Labels. This
     * method also starts the timer.
     */
    @FXML
    public void onClickStartTimer() {
        if (timerViewModel.studyTimeline != null) {
            timerViewModel.stopTimer(timerViewModel.studyTimeline);
        }
        timerViewModel.setStudyTimeSpinner(studyTimerSpinner.getValue());
        timerLabel.setText(timerViewModel.timerModel.toString());

        timerViewModel.setRestTimerSpinner(restTimerSpinner.getValue());

        timerViewModel.setRepTimerSpinner(repTimerSpinner.getValue());
        totalRepTimerLabel.setText(timerViewModel.timerModel.stringOf());

        timerViewModel.startStudyTimer();
        timerOnView.toFront();
    }

    /**
     * Timer pauses whenever the user wants to stop the timer.
     */
    public void onCLickStopButton() {
        timerViewModel.pauseTimer(timerViewModel.studyTimeline);
        cancelPane.toFront();
    }

    /**
     * Stops the timer and return the user to the setTimerView.
     */
    public void onCLickYesButton() {
        timerViewModel.stopTimer(timerViewModel.studyTimeline);
        setTimerView.toFront();
        failPane.toFront();
    }

    public void onClickNoButton() {
        timerViewModel.studyTimeline.play();
        timerOnView.toFront();
    }

    public void onClickUnderstandButton () {
        setTimerView.toFront();
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
    public void update(int time, int reps, String string, int currentRep) {
        timerLabel.setText(String.valueOf(time));
        totalRepTimerLabel.setText(String.valueOf(reps));
        typeOfTimerLabel.setText(string);
        repTimerLabel.setText(String.valueOf(currentRep));
    }

    @Override
    public void update(TimerModel timer) {
        timerLabel.setText(timer.toString());
    }

}