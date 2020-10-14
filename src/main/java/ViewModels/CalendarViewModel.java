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

    public static void addCalendarEvents(String nameTextField, String hour, String min, String year, String month, String day, Color color){
       // CalendarEventModel calendarEventsModel = new CalendarEventModel(nameTextField, hour, min, year, month, day, color );
        // TODO add to GUI
      //  addCalendarEvent(calendarEventsModel);
        //TODO save list between program startups
        //ToDoListHandler.saveToDoList(allToDoLists);

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


