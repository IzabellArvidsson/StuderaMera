package ViewModels;

import Models.CalendarEventModel;
import ViewControllers.EventInCalendarController;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.awt.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;

public class CalendarViewModel {

    private static ArrayList<CalendarEventModel> allCalendarEventModels = new ArrayList<>();

    private static ArrayList<CalendarEvent> allCalendarEvents = new ArrayList<>();

    public static void addCalendarEvents(String nameTextField, String sHour, String sMin, String eMin, String eHour, String year, String month, String day, /*Color color,*/ FlowPane mondayFlowPane){
        CalendarEvent calendarEvents;
        calendarEvents = new CalendarEvent(nameTextField, sHour, sMin, eMin, eHour, year, month, day /*, color*/);
        System.out.println(calendarEvents);
        mondayFlowPane.getChildren().add(new EventInCalendarController(calendarEvents));
        addCalendarEvent(calendarEvents);
        CalendarEventHandler.saveCalendarEvent(allCalendarEvents);

    }

    public void addCalendarEvent(String title, String time, FlowPane eventCalendarPane){
        CalendarEventModel calendarEventModel = new CalendarEventModel(title,time);
        eventCalendarPane.getChildren().add(new EventInCalendarController(calendarEventModel));

        addEventToCalendar(calendarEventModel);
    }



    private void addEventToCalendar(CalendarEventModel calendarEventModel){
        allCalendarEventModels.add(calendarEventModel);
    }
}


