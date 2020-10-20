package ViewModels;

import Models.CalendarEvent;
import Models.CalendarModel;
import Models.ToDoLists;
import ViewControllers.CalendarController;
import javafx.scene.layout.FlowPane;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class CalendarEventHandler {

    /**
     * Saves the content of allCalendarEvents to Models.CalendarEvents.ser to save events between program restarts.
     * @param calEvents a list of all CalendarEvents that are in the calendar
     */

    public static void saveCalendarEvent(ArrayList<CalendarEvent> calEvents) {
        try {
            FileOutputStream fileOut = new FileOutputStream("Models.CalendarEvents.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(calEvents);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in Models.CalendarEvents.ser");
            System.out.println(calEvents.size());
        } catch (IOException i) {
            i.printStackTrace();
        }
    }


    /**
     * reads saved CalendarEvent file and adds events to GUI (on startup and when viewed month is switched)
     * @param dayList a list containing the CalendarModel (FlowPanes) in which the CalendarEvents are to be placed.
     */
    public static void loadCalendarEvent(ArrayList<CalendarModel> dayList) {
        try {
            FileInputStream fileIn = new FileInputStream("Models.CalendarEvents.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<CalendarEvent> calendarEvents = (ArrayList<CalendarEvent>) in.readObject();
            for (CalendarEvent calEvent : calendarEvents) {
                CalendarModel flowPane = findFlowPane(calEvent.getDay(), calEvent.getMonth(), dayList);
                if (flowPane != null) {
                    System.out.println("Adding cal event " + calEvent.getName());
                    CalendarViewModel.addCalendarEvents(calEvent, flowPane);
                }
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

    /**
     * Finds FlowPane for right day to add event to.
     * @param day String from calendarEvent with day of month
     * @param month String from calendarEvent with mont of year
     * @param dayList list of all the calendarModels in GUI
     * @return CalendarModel (FlowPane) with date matching CalendarEvents date
     */
    public static CalendarModel findFlowPane(String day, String month, ArrayList<CalendarModel> dayList){
        String c = (day + "/" + month);
        for (CalendarModel calendarModel : dayList) {
            String s = (calendarModel.getLocalDate().getDayOfMonth() + "/" + calendarModel.getLocalDate().getMonthValue());
            if (c.equals(s)) {
                return calendarModel;
            }
        }
        return null;
    }

    /**
     * upon program startup adds events from save file to list to be added to allCalendarEvents
     * @return list of previous CalendarEvents
     */
    public static ArrayList<CalendarEvent> loadOldCalendarEvent() {
        try {
            FileInputStream fileIn = new FileInputStream("Models.CalendarEvents.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<CalendarEvent> calendarEvents = (ArrayList<CalendarEvent>) in.readObject();

            in.close();
            fileIn.close();
            return calendarEvents;
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Models.CalendarEvents class not found");
            c.printStackTrace();
        }
        return null;
    }

}


