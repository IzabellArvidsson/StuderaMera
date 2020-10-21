package ViewModels;

import Models.CalendarEvent;
import Views.EventInCalendarView;
import javafx.scene.layout.FlowPane;

public class CalendarViewModel {

    /**
     * The logic that adds CalendarEvents to GUI is called in all methods that add things to GUI
     * @param calendarEvent CalendarEvent to be added
     * @param flowPane CalendarModel (FlowPane) for event to be added to
     */
    public static void addCalendarEvents(CalendarEvent calendarEvent, FlowPane flowPane) {
        System.out.println(calendarEvent);
        if (flowPane != null) {
            flowPane.getChildren().add(new EventInCalendarView(calendarEvent));
        }

    }

}


