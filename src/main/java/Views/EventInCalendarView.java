package Views;

import Models.CalendarEventModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.HashMap;

/**
 * This class is responsible for setting the values for the calendarEvent -FXML-component in the Calendar (Name, time, color)
 * <p>
 * Used in CalendarViewModel
 * <p>
 * Author: Ida
 */

public class EventInCalendarView extends AnchorPane {
    private final HashMap<String, String> stringToColor = new HashMap<>();
    CalendarEventModel calendarEvent;
    //private OnClickPaneController onClickPaneController = new OnClickPaneController();
    @FXML
    private Label startTimeLabel;
    @FXML
    private Label eventNameLabel;
    @FXML
    private Label endTimeLabel;
    @FXML
    private AnchorPane calEventAnchorPane;
    @FXML
    private AnchorPane clickPane;


    /**
     * sets values for the graphic representation of CalendarEvents
     *
     * @param calEvent CalendarEvent used to create graphic representation
     */
    public EventInCalendarView(CalendarEventModel calEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml_files/CalendarEvent.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        setColors();
        this.calendarEvent = calEvent;
        eventNameLabel.setText(calEvent.getName());
        startTimeLabel.setText(calEvent.getsHour() + ":" + calEvent.getsMin());
        endTimeLabel.setText(calEvent.geteHour() + ":" + calEvent.geteMin());
        System.out.println("Anchorpane " + calEventAnchorPane);
        setEventColor(calEvent, calEventAnchorPane);


    }

    public void setColors() {
        stringToColor.put("Röd", "#ff5d5d");
        stringToColor.put("Blå", "#72bcff");
        stringToColor.put("Grön", "#5cec5c");
        stringToColor.put("Gul", "#ffff00");
        stringToColor.put("Orange", "#ffc04c");
        stringToColor.put("Rosa", "#ffa6b5");
        stringToColor.put("Färg", "#c5c5c5");
        stringToColor.put("Lila", "#d068ff");
    }


    private void setEventColor(CalendarEventModel calEvent, AnchorPane anchPane) {
        String color = stringToColor.get(calEvent.getColor());
        anchPane.setStyle("-fx-background-color: " + color);
    }


}
