package ViewModels;

import Models.CalendarEvent;
import Models.ToDoLists;
import javafx.scene.layout.FlowPane;

import java.io.*;
import java.util.ArrayList;

public class CalendarEventHandler {

    public static void saveToDoList(ArrayList<ToDoLists> toDoLists) {
        try {
            FileOutputStream fileOut = new FileOutputStream("Models.ToDoLists.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(toDoLists);
            out.close();
            fileOut.close();
            System.out.print("Serialized data is saved in Models.ToDoLists.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
/*
    public static void writeCalendarEvent(FlowPane flowPane) {
        try {
            FileInputStream fileIn = new FileInputStream("Models.CalendarEvents.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<CalendarEvent> calendarEvents = (ArrayList<CalendarEvent>) in.readObject();
            for (int i = 0; i < calendarEvents.size(); i++){
                String name = calendarEvents.get(i).getName();

                CalendarViewModel.addCalendarEvents(name, flowPane);
            }
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Models.CalendarEvents class not found");
            c.printStackTrace();
        }
    }*/

}


