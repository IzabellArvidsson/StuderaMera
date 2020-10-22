package Views;

import Factory.OnClickPaneController;
import Models.CalendarEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.HashMap;

public class EventInCalendarView extends AnchorPane {
    @FXML private Label startTimeLabel;
    @FXML private Label eventNameLabel;
    @FXML private Label endTimeLabel;
    @FXML private AnchorPane calEventAnchorPane;
    private OnClickPaneController onClickPaneController = new OnClickPaneController();


    /**
     *sets values for the graphic representation of CalendarEvents
     * @param calEvent CalendarEvent used to create graphic representation
     */
    public EventInCalendarView(CalendarEvent calEvent){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml_files/CalendarEvent.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        setColors();
        eventNameLabel.setText(calEvent.getName());
        startTimeLabel.setText(calEvent.getsHour() +":"+ calEvent.getsMin());
        endTimeLabel.setText(calEvent.geteHour() + ":" + calEvent.geteMin());
        System.out.println("Anchorpane " + calEventAnchorPane);
        setEventColor( calEvent, calEventAnchorPane);

    }

    private final HashMap<String, String> stringToColor = new HashMap<>();

    public void setColors() {
        stringToColor.put("Röd", "#ff5d5d");
        stringToColor.put("Blå", "#72bcff");
        stringToColor.put("Grön","#5cec5c");
        stringToColor.put("Gul", "#ffff00");
        stringToColor.put("Orange", "#ffc04c");
        stringToColor.put("Rosa", "#ffa6b5");
        stringToColor.put("Färg", "#c5c5c5");
        stringToColor.put("Lila", "#d068ff");
    }
    @FXML
    private void setEventColor(CalendarEvent calEvent, AnchorPane anchPane){
        String color = stringToColor.get(calEvent.getColor());
        anchPane.setStyle("-fx-background-color: "+ color);
    }

}
