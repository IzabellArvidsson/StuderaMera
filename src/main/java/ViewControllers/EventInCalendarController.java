package ViewControllers;

import Models.CalendarEventModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class EventInCalendarController extends AnchorPane {

    @FXML
    private Text eventTitleText, eventTimeText;

    public EventInCalendarController(CalendarEventModel calendarEventModel){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml_files/EventForCalendar.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        eventTitleText.setText(calendarEventModel.getTitleText());
        eventTimeText.setText(calendarEventModel.getTimeText());


    }
}
