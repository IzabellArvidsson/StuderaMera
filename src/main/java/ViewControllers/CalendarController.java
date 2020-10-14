package ViewControllers;

import Factory.IPane;
import ViewModels.CalendarEventHandler;
import ViewModels.CalendarViewModel;
import ViewModels.ToDoListHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class CalendarController implements IPane {

    @FXML private AnchorPane addToCalendarPane;
    @FXML TextField dateDay;
    @FXML TextField dateMonth;
    @FXML TextField dateYear;
    @FXML Button nextMonthButton, lastMonthButton;
    @FXML TextField nameTextField;
    @FXML TextField startTimeHourTextField, startTimeMinTextField, endTimeHourTextField, endTimeMinTextField;
    @FXML TextField locationTextField;
    @FXML TextArea descriptionTextArea;
    @FXML Button addEventButton;
    @FXML MenuButton colorMenuButton;
    @FXML FlowPane mondayFlowPane;

    private PaneController paneController = new PaneController();



    public void onClickBackToOverview() {
        paneController.showOverviewPane();
    }

    public void onClickGoToHelp () {
        paneController.showHelpPane();
    }

    public void openAddToCalendar(){
        addToCalendarPane.toFront();
    }

    public void closeAddToCalendar(){
        addToCalendarPane.toBack();
    }

    @FXML
    private void onClickStuderaMera () {
        paneController.showFirstViewPane();
    }

    /*@Override
    public void initPane(PaneController paneController) {
        this.paneController = paneController;
    }
    */

    @FXML
    private void onClickSaveEvent(){
        CalendarViewModel.addCalendarEvents(nameTextField.getText(), startTimeHourTextField.getText(), startTimeMinTextField.getText(), endTimeMinTextField.getText(), endTimeHourTextField.getText(), dateYear.getText(), dateMonth.getText(), dateDay.getText(), mondayFlowPane);
        closeAddToCalendar();
        nameTextField.clear();
        dateDay.clear();
        dateMonth.clear();
        dateYear.clear();
        endTimeMinTextField.clear();
        endTimeHourTextField.clear();
        startTimeHourTextField.clear();
        startTimeMinTextField.clear();
        locationTextField.clear();
        descriptionTextArea.clear();

    }

    @FXML
    public void writingSavedCalendarEvent(){
       // CalendarEventHandler.writeCalendarEvent(mondayFlowPane/*remember to change this bich*/);
    }

    @Override
    public void initPane(PaneController paneController) {
        this.paneController = paneController;
        writingSavedCalendarEvent();
    }


}
