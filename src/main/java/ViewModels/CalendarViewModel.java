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


    public static void addCalendarEvents(CalendarEvent calendarEvent, FlowPane flowPane){
        System.out.println(calendarEvent);
        if(flowPane != null) {
            flowPane.getChildren().add(new EventInCalendarController(calendarEvent));
        }

    }

}


