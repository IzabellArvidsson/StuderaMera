package ViewControllers;

import Models.CalendarEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.IOException;

public class EventInCalendarController extends AnchorPane {
    @FXML Label startTimeLabel;
    @FXML Label eventNameLabel;
    @FXML Label endTimeLabel;
    @FXML AnchorPane calEventAnchorPane;



    public EventInCalendarController(CalendarEvent calEvent){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml_files/CalendarEvent.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        eventNameLabel.setText(calEvent.getName());
        startTimeLabel.setText(calEvent.getsHour() +":"+ calEvent.getsMin());
        endTimeLabel.setText(calEvent.geteHour() + ":" + calEvent.geteMin());
        //setEventColor( calEvent, calEventAnchorPane);

    }
    @FXML
    private void setEventColor(CalendarEvent calEvent, AnchorPane anchPane){
        String color = toRGBCode(calEvent.getColor());
        anchPane.setStyle("-fx-background-color: "+ color);
    }

    private String toRGBCode( Color color )
    {
        return String.format( "#%02X%02X%02X",
                (int)( color.getRed() * 255 ),
                (int)( color.getGreen() * 255 ),
                (int)( color.getBlue() * 255 ) );
    }
}
