package Views;

import Factory.IOnClickPane;
import Factory.OnClickPaneController;
import Models.CalendarEvent;
import Models.CalendarModel;
import ViewModels.CalendarViewModel;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CalendarView implements IOnClickPane, Initializable {

    private static ArrayList<CalendarEvent> allCalendarEvents = new ArrayList<>();
    private final CalendarViewModel calendarViewModel = new CalendarViewModel();
    private final CalendarModel calendarModel = new CalendarModel();
    @FXML
    ComboBox colorComboBox;
    @FXML
    private AnchorPane addToCalendarPane;
    @FXML
    private ComboBox dateDay;
    @FXML
    private ComboBox dateMonth;
    @FXML
    private Button nextMonthButton, lastMonthButton;
    @FXML
    private TextField nameTextField, showName;
    @FXML
    private TextField startTimeHourTextField, startTimeMinTextField, endTimeHourTextField, endTimeMinTextField, showStartTime, showEndTime, showDateDay, showDateMonth;
    @FXML
    private TextField locationTextField, showLocation;
    @FXML
    private TextArea descriptionTextArea, showDescription;
    @FXML
    private Button addEventButton;
    @FXML
    private AnchorPane eventPane;
    @FXML
    private GridPane gridPane;
    @FXML
    private Text dateText, eventTitleText, eventTimeText; //TODO: why clear the texts?FXML
    private YearMonth yearMonth = YearMonth.now();
    private ArrayList<CalendarModel> allCalendarDays = new ArrayList<CalendarModel>(31);
    private OnClickPaneController paneController = new OnClickPaneController();


    public CalendarView() {
    }

    /**
     * adds event to list allCalendarEvent
     *
     * @param calendarEvent event to be added
     */
    private static void addToAllCalendarEvents(CalendarEvent calendarEvent) {
        allCalendarEvents.add(calendarEvent);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateText.setText(String.valueOf(yearMonth));
        columnAndRows();
        populateMonth(YearMonth.now());
        colorComboBox.getItems().addAll("Färg", "Blå", "Grön", "Gul", "Orange", "Röd", "Rosa", "Lila");
        colorComboBox.getSelectionModel().select("Färg");
        dateDay.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
        dateMonth.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");

    }

    /**
     * show event details when event is pressed
     */
    public void clickGridPane() {
        gridPane.getChildren().forEach(item -> {
            item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    eventPane.toFront();
                    //populateEventPane(item);
                }
            });
        });
    }

    /*public void populateEventPane(Node node) {
        CalendarEvent calEvent = node.p;
        showName.setText(calEvent.getName());
        showDescription.setText(calEvent.getDescription());
        showLocation.setText(calEvent.getPlace());
        showStartTime.setText(calEvent.getsHour() + ":" + calEvent.getsMin());
        showEndTime.setText(calEvent.geteHour()+":"+calEvent.geteMin());
        showDateMonth.setText(calEvent.getMonth());
        showDateDay.setText(calEvent.getDay());
    }*/

    public void onClickCloseEventButton() {
        eventPane.toBack();
        showDateDay.clear();
        showDateMonth.clear();
        showDescription.clear();
        showEndTime.clear();
        showStartTime.clear();
        showName.clear();
        showLocation.clear();
    }

    /**
     * sets new month, clears children of all CalendarModels, adds labels with dates for new month
     *
     * @param yearMonthNow Month of which to show dates
     */
    private void populateMonth(YearMonth yearMonthNow) {
        yearMonth = yearMonthNow;

        LocalDate localDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), 1);

        for (CalendarModel calendarModel : allCalendarDays) {
            calendarModel.getChildren().clear();

            calendarModel.setLocalDate(localDate);

            Label label = new Label();
            label.setText((localDate.getDayOfMonth() + "/" + localDate.getMonthValue()));
            label.setFont(Font.font("Georgia", 20));
            calendarModel.getChildren().add(label);

            localDate = localDate.plusDays(1);

            if (calendarModel.getLocalDate().equals(LocalDate.now())) {
                calendarModel.setStyle("-fx-background-color: white");
            }
        }

    }

    /**
     * adds a CalendarModel to each column of the calendar GridPane
     */
    private void columnAndRows() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 31; j++) {
                CalendarModel calendarModel = new CalendarModel();
                calendarModel.setPrefSize(70, gridPane.getHeight());

                gridPane.add(calendarModel, j, i);
                allCalendarDays.add(calendarModel);
            }
        }
    }

    /**
     * changes month to previous month by changing dates in CalendarModels and loading the CalendarEvents corresponding to those days
     */
    public void previousMonth() {
        yearMonth = yearMonth.minusMonths(1);
        dateText.setText(String.valueOf(yearMonth));
        populateMonth(yearMonth);
        loadSavedCalendarEvents();
    }

    /**
     * changes month to next month by changing dates in CalendarModels and loading the CalendarEvents corresponding to those days
     */
    public void nextMonth() {
        yearMonth = yearMonth.plusMonths(1);
        dateText.setText(String.valueOf(yearMonth));
        populateMonth(yearMonth);
        loadSavedCalendarEvents();
    }

    public void onClickGoToHelp() {
        paneController.showHelpPane();
    }

    public void openAddToCalendar() {
        addToCalendarPane.toFront();
    }

    public void closeAddToCalendar() {
        addToCalendarPane.toBack();
    }

    @FXML
    private void onClickStuderaMera() {
        paneController.showFirstViewPane();
    }

    /**
     * Gets parameters from GUI and creates CalendarEvent then adds it to FlowPane and allCalendarEvents List,
     * saves the list to Models.CalendarEvents.ser and clears fields in addToCalendarPane as well as sends it to back.
     */
    @FXML
    private void onClickSaveEvent() {
        CalendarModel flowPane = findFlowPane(dateDay.getSelectionModel().selectedItemProperty().getValue().toString(), dateMonth.getSelectionModel().selectedItemProperty().getValue().toString());
        CalendarEvent calEvent = new CalendarEvent(nameTextField.getText(),
                startTimeHourTextField.getText(),
                startTimeMinTextField.getText(),
                endTimeMinTextField.getText(),
                endTimeHourTextField.getText(),
                locationTextField.getText(),
                dateMonth.getSelectionModel().selectedItemProperty().getValue().toString(),
                dateDay.getSelectionModel().selectedItemProperty().getValue().toString(),
                descriptionTextArea.getText(),
                colorComboBox.getSelectionModel().selectedItemProperty().getValue().toString());
        CalendarViewModel.addCalendarEvents(calEvent, flowPane);
        addToAllCalendarEvents(calEvent);
        saveList();
        closeAddToCalendar();
        nameTextField.clear();
        dateDay.getSelectionModel().select("Dag");
        dateMonth.getSelectionModel().select("Mån");
        endTimeMinTextField.clear();
        endTimeHourTextField.clear();
        startTimeHourTextField.clear();
        startTimeMinTextField.clear();
        locationTextField.clear();
        descriptionTextArea.clear();
        colorComboBox.getSelectionModel().select("Färg");

    }

    /**
     * calls loadCalendarEvent from CalendarEventHandler which adds CalendarEvents to FlowPane from saved file
     */
    @FXML
    public void loadSavedCalendarEvents() {
        CalendarViewModel.loadCalendarEvent(allCalendarDays);
    }

    /**
     * sets PaneController and loads old events int Calendar as well as adding them to the allCalendarEvents List
     *
     * @param paneController sets painController of CalendarPanes
     */
    @Override
    public void initPane(OnClickPaneController paneController) {
        this.paneController = paneController;
        loadSavedCalendarEvents();
        if (CalendarViewModel.loadOldCalendarEvent() != null) {
            allCalendarEvents.addAll(CalendarViewModel.loadOldCalendarEvent());
        }
    }

    /**
     * Finds CalendarModel (FlowPane) in which to put CalendarEvent
     *
     * @param day   String with day og month
     * @param month String with mont of year
     * @return CalendarModel corresponding to current CalendarEvent
     */
    public CalendarModel findFlowPane(String day, String month) {
        String c = (day + "/" + month);
        for (CalendarModel allCalendarDay : allCalendarDays) {
            String s = (allCalendarDay.getLocalDate().getDayOfMonth() + "/" + allCalendarDay.getLocalDate().getMonthValue());
            if (c.equals(s)) {
                return allCalendarDay;
            }
        }
        return null;
    }

    /**
     * Saves contents of allCalendarEvents to Models.CalendarEvents.ser
     */
    public void saveList() {
        CalendarViewModel.saveCalendarEvent(allCalendarEvents);
    }

    public void onClickBackToOverview() {
        paneController.showFirstViewPane();
    }

}

