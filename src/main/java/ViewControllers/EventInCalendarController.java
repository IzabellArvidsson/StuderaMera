package ViewControllers;

import Models.CalendarEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.HashMap;

public class EventInCalendarController extends AnchorPane {
    @FXML Label startTimeLabel;
    @FXML Label eventNameLabel;
    @FXML Label endTimeLabel;
    @FXML AnchorPane calEventAnchorPane;


    /**
     *sets values for the graphic representation of CalendarEvents
     * @param calEvent CalendarEvent used to create graphic representation
     */
    public EventInCalendarController(CalendarEvent calEvent){
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

    private final HashMap<String, Color> stringToColor = new HashMap<>();

    public void setColors() {
        stringToColor.put("Röd", Color.RED);
        stringToColor.put("Blå", Color.BLUE);
        stringToColor.put("Grön",Color.GREEN);
        stringToColor.put("Gul", Color.YELLOW);
        stringToColor.put("Orange", Color.ORANGE);
        stringToColor.put("Rosa", Color.PINK);
        stringToColor.put("Färg", Color.GRAY);
    }
    @FXML
    private void setEventColor(CalendarEvent calEvent, AnchorPane anchPane){
        Color c = stringToColor.get(calEvent.getColor());
        String color = toRGBCode(c);
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
