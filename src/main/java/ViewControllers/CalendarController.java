package ViewControllers;

import Factory.IPane;
import Models.CalendarModel;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import java.awt.*;

import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.control.Button;

public class CalendarController implements IPane, Initializable {

    @FXML private AnchorPane addToCalendarPane, eventPane;
    //@FXML private ScrollPane calendarScrollPane;
    @FXML private GridPane gridPane;
    @FXML private Text dateText;
    //@FXML private Button nextMonthButton, previousMonthButton;


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
            label.setText(String.valueOf(localDate.getDayOfMonth() + "/" + localDate.getMonthValue()));
            label.setFont(Font.font("Georgia", 20));


           // calendarModel.se(label, 5.0);
           // calendarModel.setLeftAnchor(label, 5.0);


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
    }

    public void nextMonth(){
        yearMonth = yearMonth.plusMonths(1);
        dateText.setText(String.valueOf(yearMonth));
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
    private void onClickStuderaMera ()  {
        paneController.showFirstViewPane();
    }

    @Override
    public void initPane(PaneController paneController) {
        this.paneController = paneController;
    }


}

