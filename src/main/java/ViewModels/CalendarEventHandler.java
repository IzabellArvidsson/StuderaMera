package ViewModels;

import Models.CalendarEvent;
import Models.ToDoLists;
import javafx.scene.layout.FlowPane;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class CalendarEventHandler {

    public static void saveCalendarEvent(ArrayList<CalendarEvent> calEvent) {
        try {
            FileOutputStream fileOut = new FileOutputStream("Models.CalendarEvents.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(calEvent);
            out.close();
            fileOut.close();
            System.out.print("Serialized data is saved in Models.CalendarEvents.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void writeCalendarEvent(FlowPane flowPane) {
        try {
            FileInputStream fileIn = new FileInputStream("Models.CalendarEvents.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<CalendarEvent> calendarEvents = (ArrayList<CalendarEvent>) in.readObject();
            for (int i = 0; i < calendarEvents.size(); i++){
                String name = calendarEvents.get(i).getName();
                String day = calendarEvents.get(i).getDay();
                String sHour = calendarEvents.get(i).getsHour();
                String sMin = calendarEvents.get(i).getsMin();
                String eHour = calendarEvents.get(i).geteHour();
                String eMin = calendarEvents.get(i).geteMin();
                String place = calendarEvents.get(i).getPlace();
                String month = calendarEvents.get(i).getMonth();
                String description = calendarEvents.get(i).getDescription();
                Color color = calendarEvents.get(i).getColor();

                CalendarViewModel.addCalendarEvents(name, sHour, sMin, eMin, eHour, month, day, flowPane);
            }
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Models.CalendarEvents class not found");
            c.printStackTrace();
        }
    }

}


