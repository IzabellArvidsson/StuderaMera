package ViewModels;

import Models.CalendarEvent;
import Models.ToDoLists;
import ViewControllers.EventInCalendarController;
import ViewControllers.listInToDoController;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.awt.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;

public class CalendarViewModel {


    private static ArrayList<CalendarEvent> allCalendarEvents = new ArrayList<>();

    public static void addCalendarEvents(String nameTextField,
                                         String sHour,
                                         String sMin,
                                         String eMin,
                                         String eHour,
                                         String month,
                                         String day,
                                        /*Color color,*/
                                         FlowPane flowPane){
        CalendarEvent calendarEvents;
        calendarEvents = new CalendarEvent(nameTextField, sHour, sMin, eMin, eHour, month, day /*, color*/);
        System.out.println(calendarEvents);
        flowPane.getChildren().add(new EventInCalendarController(calendarEvents));
        addCalendarEvent(calendarEvents);
        CalendarEventHandler.saveCalendarEvent(allCalendarEvents);

    }

    private static void addCalendarEvent(CalendarEvent calendarEvent){
        allCalendarEvents.add(calendarEvent);
    }


}


