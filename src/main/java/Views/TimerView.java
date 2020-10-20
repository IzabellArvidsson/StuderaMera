package Views;

import Factory.IOnClickPane;
import Factory.OnClickPaneController;
import Models.TimerModel;
import ObserverInterfaces.TimerObserver;
import ViewModels.TimerViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The controller class for the view. This class handles all the information about the view. It also updates the view
 * after updates from other classes.
 */
public class TimerView extends AnchorPane implements Initializable, TimerObserver, IOnClickPane {

    @FXML private AnchorPane timerOnView, cancelPane, setTimerView, failPane, finishedPane;
    @FXML private Spinner<Integer> studyTimerSpinner, restTimerSpinner, repTimerSpinner;
    @FXML private Label timerLabel, repTimerLabel, totalRepTimerLabel, typeOfTimerLabel;
    @FXML private ImageView flowerChangingImage, deadFlowerImage;

    private final TimerViewModel timerViewModel = new TimerViewModel();

    OnClickPaneController paneController = new OnClickPaneController();

    /**
     * Initializes the different spinner values and register the class as an observer
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /*-----------------------------------Register this class as an observer---------------------------------------*/
        timerViewModel.register(this);

        /*----------------------------------------Spinner initialize--------------------------------------------------*/

        SpinnerValueFactory<Integer> studyFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 20, 5);
        this.studyTimerSpinner.setValueFactory(studyFactory);

        SpinnerValueFactory<Integer> restFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory( 1, 40, 5, 5);
        this.restTimerSpinner.setValueFactory(restFactory);

        SpinnerValueFactory<Integer> repFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1, 1);
        this.repTimerSpinner.setValueFactory(repFactory);
    }

    /**
     * Sends the value of the studyspinner to a method in TimerViewModel
     */
    @FXML
    private void setStudyTime(){
        timerViewModel.setStudyTimerSpinner(studyTimerSpinner.getValue());
    }

    /**
     * Sends the value of the restspinner to a method in TimerViewModel
     */
    @FXML
    private void setRestTime() { timerViewModel.setRestTimerSpinner(restTimerSpinner.getValue()); }

    /**
     * Sends the value of the repetition spinner to a method in TimerViewModel
     */
    @FXML
    private void setRep() {
        timerViewModel.setRepTimerSpinner(repTimerSpinner.getValue());
    }

    /**
     * Sets the first picture when you start the timer
     */
    private void setImage() {
        flowerChangingImage.setImage(new Image("/images/flower/plant_0_pot.png"));
    }

    /**
     * Changes the image of the flower depending on how big part of the studying the user has done
     * @param countUp Is the variable that decides when the application should change the image
     */
    private void imageLoader(int countUp) {

        int totalTime = (studyTimerSpinner.getValue() * repTimerSpinner.getValue())*60;

        switch(timerViewModel.imageModel.checkChangeImage(countUp, totalTime)) {
            case 1:
                flowerChangingImage.setImage(new Image("/images/flower/plant_1.png"));
                deadFlowerImage.setImage(new Image("/images/flower/plant_1_dead.png"));
                break;
            case 2:
                flowerChangingImage.setImage(new Image("/images/flower/plant_2.png"));
                deadFlowerImage.setImage(new Image("/images/flower/plant_2_dead.png"));
                break;
            case 3:
                flowerChangingImage.setImage(new Image("/images/flower/plant_3.png"));
                deadFlowerImage.setImage(new Image("/images/flower/plant_3_dead.png"));
                break;
            case 4:
                flowerChangingImage.setImage(new Image("/images/flower/plant_4.png"));
                deadFlowerImage.setImage(new Image("/images/flower/plant_4_dead.png"));
                break;
            case 5:
                flowerChangingImage.setImage(new Image("/images/flower/plant_5.png"));
                deadFlowerImage.setImage(new Image("/images/flower/plant_5_dead.png"));
                break;
            case 6:
                flowerChangingImage.setImage(new Image("/images/flower/plant_6.png"));
                deadFlowerImage.setImage(new Image("/images/flower/plant_6_dead.png"));
                break;
        }
    }

    /*--------------------------------------------OnClick methods-----------------------------------------------------*/

    /**
     * This method makes sure that the right values are written to the Labels. This method also starts the timer.
     */
    @FXML
    private void onClickStartTimer() {
        setStudyTime();
        setRestTime();
        setRep();
        setImage();
        timerViewModel.setCountUpInt();
        timerViewModel.setTimelines();

        timerViewModel.startTimer(timerViewModel.studyTimeline);

        timerOnView.toFront();
    }

    /**
     * Timer pauses whenever the user wants to stop the timer.
     */
    @FXML
    private void onCLickStopButton() {
        timerViewModel.pauseTimer(timerViewModel.studyTimeline);
        cancelPane.toFront();
    }

    /**
     * Stops the timer and return the user to the setTimerView.
     */
    @FXML
    private void onCLickYesButton() {
        timerViewModel.stopTimer(timerViewModel.studyTimeline);
        setTimerView.toFront();
        failPane.toFront();

    }

    /**
     * Returns the user to the timer and starts the timer again
     */
    @FXML
    private void onClickNoButton() {
        timerViewModel.studyTimeline.play();
        timerOnView.toFront();
    }

    /**
     * Sends the user to the view where you set values
     */
    @FXML
    private void onClickUnderstandButton () {
        setTimerView.toFront();
    }

    /**
     * Sends the user to the help part of the application
     */
    @FXML
    private void onClickGoToHelp() {
        paneController.showHelpPane();
    }

    /**
     * Sends the user to the tips part of the application
     */
    @FXML
    private void onCLickGoToTips() {
        paneController.showTipsViewPane();
    }

    /**
     * Sends the user to the overview in the planning part of the application
     */
    @FXML
    private void onClickStartPlanning() {
        paneController.showFirstViewPane();
    }

    /**
     * Takes the user back to the view where you set the values
     */
    @FXML
    private void onClickBackToStart() {
        setTimerView.toFront();
    }

    /**
     * The escape hatch which takes the user back to the first side
     */
    @FXML
    private void onClickStuderaMera() {
        paneController.showFirstViewPane();
    }

    /*----------------------------------------Observer pattern methods------------------------------------------------*/

    /**
     * The method who receives information about updates from TimerViewModel and with this information updates the view
     * @param time Updates which number the timer is on
     * @param reps Updates the total number of reps that the user has decided
     * @param string Updates the text that says if the user should study or rest
     * @param currentRep Updates which repetition the user is currently on
     * @param stopped A boolean which checks if the timer is finished
     * @param countUp The integer variable who keeps track of how many seconds has passed
     */
    @Override
    public void update(int time, int reps, String string, int currentRep, boolean stopped, int countUp) {
        timerLabel.setText(String.valueOf(time));
        totalRepTimerLabel.setText(String.valueOf(reps));
        typeOfTimerLabel.setText(string);
        repTimerLabel.setText(String.valueOf(currentRep));
        imageLoader(countUp);

        if (stopped) {
            flowerChangingImage.setImage(new Image("/images/flower/plant_7_done.png"));
            finishedPane.toFront();
        }
    }

    /**
     * Updates the label of the timer with the current minutes and seconds
     * @param timer The variable that will be updated
     */
    @Override
    public void update(TimerModel timer) {
        timerLabel.setText(timer.toString());
    }

    /*--------------------------------------------Factory method------------------------------------------------------*/

    /**
     * The method for the factory design pattern
     * @param paneController Initializes the panecontroller
     */
    @Override
    public void initPane(OnClickPaneController paneController) {
        this.paneController = paneController;
    }

}