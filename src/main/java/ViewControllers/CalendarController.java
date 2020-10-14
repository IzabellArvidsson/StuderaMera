package ViewControllers;

import Factory.IPane;
import ViewModels.CalendarEventHandler;
import ViewModels.CalendarViewModel;
import ViewModels.ToDoListHandler;
import Models.CalendarModel;
import ViewModels.CalendarViewModel;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;

import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CalendarController implements IPane, Initializable {

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
    @FXML private AnchorPane addToCalendarPane, eventPane;
    @FXML private GridPane gridPane;
    @FXML private Text dateText, eventTitleText, eventTimeText; //TODO: why clear the texts?

    private CalendarViewModel calendarViewModel = new CalendarViewModel();
    private CalendarModel calendarModel = new CalendarModel();
    private YearMonth yearMonth = YearMonth.now();
    private ArrayList<CalendarModel> allCalendarDays = new ArrayList<CalendarModel>(31);
    private PaneController paneController = new PaneController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateText.setText(String.valueOf(yearMonth));
        columnAndRows();
        populateMonth(YearMonth.now());
    }

    public void clickGridPane(){
        gridPane.getChildren().forEach(item -> {
            item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    eventPane.toFront();
                }
            });
        });
    }

    public void onClickCloseEventButton(){
        eventPane.toBack();
    }


    private void populateMonth (YearMonth yearMonthNow){
        yearMonth = yearMonthNow;

        LocalDate localDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), 1);

        for(CalendarModel calendarModel : allCalendarDays){
            if(calendarModel.getChildren().size() != 0){
                calendarModel.getChildren().remove(0);
            }

            calendarModel.setLocalDate(localDate);

            Label label = new Label();
            label.setText((localDate.getDayOfMonth() + "/" + localDate.getMonthValue()));
            label.setFont(Font.font("Georgia", 20));
            calendarModel.getChildren().add(label);

            localDate = localDate.plusDays(1);

            if(calendarModel.getLocalDate().equals(LocalDate.now())){
                calendarModel.setStyle("-fx-background-color: white");
            }
        }
    }


    private void columnAndRows(){
        for(int i=0; i<1; i++){
            for(int j = 0; j<31; j++){
                CalendarModel calendarModel = new CalendarModel();
                calendarModel.setPrefSize(70,gridPane.getHeight());

                gridPane.add(calendarModel,j,i);
                allCalendarDays.add(calendarModel);
            }
        }
    }


    public void previousMonth(){
        yearMonth = yearMonth.minusMonths(1);
        dateText.setText(String.valueOf(yearMonth));
        populateMonth(yearMonth);
    }

    public void nextMonth(){
        yearMonth = yearMonth.plusMonths(1);
        dateText.setText(String.valueOf(yearMonth));
        populateMonth(yearMonth);
    }


   public void onClickSaveEvent(){
       calendarViewModel.addCalendarEvent(eventTitleText.getText(), eventTimeText.getText(), calendarModel);
       closeAddToCalendar();
   }

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

