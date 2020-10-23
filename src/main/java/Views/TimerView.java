package Views;

import Factory.IOnClickPane;
import Factory.OnClickPaneController;
import interfaces.ITimerViewModel;
import ObserverInterfaces.TimerObserver;
import ViewModels.ImageViewModel;
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
 * Author: Hanna and Izabell
 * Uses: TimerObserver to send information. IOnClickPane and ITimerViewModel to get data. ImageViewModel to
 * get information on image. OnClickPaneController to get information.
 * Used by: OnClickPaneFactory to send information.
 * The controller class for the view. This class handles all the information about the view. It also updates the view
 * after updates from other classes.
 */
public class TimerView extends AnchorPane implements Initializable, TimerObserver, IOnClickPane {

    @FXML private AnchorPane timerOnView;
    @FXML private AnchorPane cancelPane;
    @FXML private AnchorPane setTimerView;
    @FXML private AnchorPane failPane;
    @FXML private AnchorPane finishedPane;

    @FXML private Spinner<Integer> studyTimerSpinner;
    @FXML private Spinner<Integer> restTimerSpinner;
    @FXML private Spinner<Integer> repTimerSpinner;

    @FXML private Label timerLabel;
    @FXML private Label repTimerLabel;
    @FXML private Label totalRepTimerLabel;
    @FXML private Label typeOfTimerLabel;

    @FXML private ImageView flowerChangingImage;
    @FXML private ImageView deadFlowerImage;

    private final ITimerViewModel iTimerViewModel = new TimerViewModel();
    private final ImageViewModel imageViewModel = new ImageViewModel();

    /**
     * To be able to use the factory pattern
     */
    OnClickPaneController paneController = new OnClickPaneController();

    /**
     * Initializes the different spinner values and register the class as an observer
     * @param url pointer to a "resource" on the world wide web
     * @param resourceBundle contains local specific objects
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /*-----------------------------------Register this class as an observer---------------------------------------*/
        iTimerViewModel.register(this);

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
        iTimerViewModel.setStudyTimerSpinner(studyTimerSpinner.getValue());
    }

    /**
     * Sends the value of the restspinner to a method in TimerViewModel
     */
    @FXML
    private void setRestTime() { iTimerViewModel.setRestTimerSpinner(restTimerSpinner.getValue()); }

    /**
     * Sends the value of the repetition spinner to a method in TimerViewModel
     */
    @FXML
    private void setRep() {
        iTimerViewModel.setRepTimerSpinner(repTimerSpinner.getValue());
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

        switch(imageViewModel.checkChangeImage(countUp, totalTime)) {
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
            default:
                flowerChangingImage.setImage(new Image("/images/flower/plant_0_pot.png"));
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
        iTimerViewModel.setCountUpInt();
        iTimerViewModel.setTimelines();

        iTimerViewModel.startStudyTime();

        timerOnView.toFront();
    }

    /**
     * Timer pauses whenever the user wants to stop the timer.
     */
    @FXML
    private void onCLickStopButton() {
        iTimerViewModel.pauseStudyTime();
        cancelPane.toFront();
    }

    /**
     * Stops the timer and return the user to the setTimerView.
     */
    @FXML
    private void onCLickYesButton() {
        iTimerViewModel.stopStudyTime();
        setTimerView.toFront();
        failPane.toFront();
    }

    /**
     * Returns the user to the timer and starts the timer again
     */
    @FXML
    private void onClickNoButton() {
        iTimerViewModel.playStudyTime();
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
     * @param reps Updates the total number of reps that the user has decided
     * @param string Updates the text that says if the user should study or rest
     * @param currentRep Updates which repetition the user is currently on
     * @param stopped A boolean which checks if the timer is finished
     * @param countUp The integer variable who keeps track of how many seconds has passed
     */
    @Override
    public void update(int reps, String string, int currentRep, boolean stopped, int countUp) {
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
     * @param time The variable that will be updated
     */
    @Override
    public void update(String time) {
        timerLabel.setText(time);
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