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
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
    @FXML private TextField dateDay;
    @FXML private TextField dateMonth;
    @FXML private TextField dateYear;
    @FXML private Button nextMonthButton, lastMonthButton;
    @FXML private TextField nameTextField;
    @FXML private TextField startTimeHourTextField, startTimeMinTextField, endTimeHourTextField, endTimeMinTextField;
    @FXML private TextField locationTextField;
    @FXML private TextArea descriptionTextArea;
    @FXML private Button addEventButton;
    @FXML private MenuButton colorMenuButton;
    private FlowPane flowPane;
    @FXML private AnchorPane eventPane;
    @FXML private GridPane gridPane;
    @FXML private Text dateText, eventTitleText, eventTimeText; //TODO: why clear the texts?

    private final CalendarViewModel calendarViewModel = new CalendarViewModel();
    private final CalendarModel calendarModel = new CalendarModel();
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
        CalendarModel flowPane = findFlowPane(dateDay.getText(), dateMonth.getText());
        CalendarViewModel.addCalendarEvents(nameTextField.getText(),
                startTimeHourTextField.getText(),
                startTimeMinTextField.getText(),
                endTimeMinTextField.getText(),
                endTimeHourTextField.getText(),
                dateMonth.getText(),
                dateDay.getText(),
                flowPane);
        closeAddToCalendar();
        nameTextField.clear();
        dateDay.clear();
        dateMonth.clear();
        endTimeMinTextField.clear();
        endTimeHourTextField.clear();
        startTimeHourTextField.clear();
        startTimeMinTextField.clear();
        locationTextField.clear();
        descriptionTextArea.clear();

    }

    @FXML
    public void writingSavedCalendarEvent(){
        CalendarEventHandler.writeCalendarEvent(flowPane);
    }

    @Override
    public void initPane(PaneController paneController) {
        this.paneController = paneController;
        writingSavedCalendarEvent();
    }

    CalendarModel findFlowPane(String day, String month){
        String c = (day + "/" + month);
        for(int i =0; i<allCalendarDays.size() ; i++ ){
        String s =(allCalendarDays.get(i).getLocalDate().getDayOfMonth() + "/" + allCalendarDays.get(i).getLocalDate().getMonthValue());
        System.out.println(s);
            if (c.equals(s)){
                return allCalendarDays.get(i);
            }
        }
        return null;
    }


}

