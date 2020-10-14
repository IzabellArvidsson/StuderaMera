package ViewModels;

import Models.CalendarEvent;
import Models.ToDoLists;
import ViewControllers.listInToDoController;
import javafx.scene.layout.FlowPane;

import java.awt.*;
import java.util.ArrayList;

public class CalendarViewModel {

    private static ArrayList<CalendarEvent> allCalendarEvents = new ArrayList<>();

    public static void addCalendarEvents(String nameTextField, String hour, String min, String year, String month, String day, Color color){
        CalendarEvent calendarEvents = new CalendarEvent(nameTextField, hour, min, year, month, day, color );
        // TODO add to GUI
        addCalendarEvent(calendarEvents);
        //TODO save list between program startups
        //ToDoListHandler.saveToDoList(allToDoLists);
    }
    private static void addCalendarEvent(CalendarEvent calendarEvent){
        allCalendarEvents.add(calendarEvent);
    }
}
