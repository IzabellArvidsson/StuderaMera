package ViewModels;

import Models.CalendarEventModel;
import Models.CalendarModel;
import Views.EventInCalendarView;
import javafx.scene.layout.FlowPane;

import java.io.*;
import java.util.ArrayList;

/**
 * This class is responsible for adding events to the calendarGUI and saving them between startups of the program
 * <p>
 * Uses EventInCalendarModel
 * <p>
 * Is used in CalendarView
 * <p>
 * Author: Ida
 */

public class CalendarViewModel {

    public ArrayList<CalendarEventModel> getAllCalendarEvents() {
        return allCalendarEvents;
    }

    private static ArrayList<CalendarEventModel> allCalendarEvents = new ArrayList<>();

    /**
     * Finds FlowPane for right day to add event to.
     *
     * @param day     String from calendarEvent with day of month
     * @param month   String from calendarEvent with mont of year
     * @param dayList list of all the calendarModels in GUI
     * @return CalendarModel (FlowPane) with date matching CalendarEvents date
     */
    public static CalendarModel findFlowPane(String day, String month, ArrayList<CalendarModel> dayList) {
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
     *
     * @return list of previous CalendarEvents
     */
    public ArrayList<CalendarEventModel> loadOldCalendarEvent() {
        try {
            FileInputStream fileIn = new FileInputStream("Models.CalendarEvents.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<CalendarEventModel> calendarEvents = (ArrayList<CalendarEventModel>) in.readObject();

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

    /**
     * The logic that adds CalendarEvents to GUI is called methods that add new events to GUI
     * @param name name from GUI
     * @param sHour Star hour from GUI
     * @param sMin Start minute from GUI
     * @param eHour End hour from GUI
     * @param eMin End minute from GUI
     * @param location Location from GUI
     * @param month month from GUI
     * @param day day from GUI
     * @param description description from GUI
     * @param color color from GUI
     * @param flowPane FlowPane calculated from date/month
     */
    public void addCalendarEvent(String name,
                                  String sHour,
                                  String sMin,
                                  String eHour,
                                  String eMin,
                                  String location,
                                  String month,
                                  String day,
                                  String description,
                                  String color, FlowPane flowPane) {
        CalendarEventModel calendarEvent = new CalendarEventModel(name,
                sHour,
                sMin,
                eHour,
                eMin,
                location,
                month,
                day,
                description,
                color);
        System.out.println(calendarEvent);
        if (flowPane != null) {
            flowPane.getChildren().add(new EventInCalendarView(calendarEvent));
        }allCalendarEvents.add(calendarEvent);

    }

    /**
     * The logic that adds CalendarEvents to GUI is called when adding previously created CalendarEvents to GUI
     * @param calendarEvent CalendarEvent to be added
     * @param flowPane CalendarModel (FlowPane) for event to be added to
     */
    public void addCalendarEvents(CalendarEventModel calendarEvent, FlowPane flowPane) {
        System.out.println(calendarEvent);
        if (flowPane != null) {
            flowPane.getChildren().add(new EventInCalendarView(calendarEvent));
        }

    }

    /**
     * Saves the content of allCalendarEvents to Models.CalendarEvents.ser to save events between program restarts.
     *
     */

    public void saveCalendarEvent() {
        ArrayList<CalendarEventModel> calEvents = getAllCalendarEvents();
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
     *
     * @param dayList a list containing the CalendarModel (FlowPanes) in which the CalendarEvents are to be placed.
     */
    public void loadCalendarEvent(ArrayList<CalendarModel> dayList) {
        try {
            FileInputStream fileIn = new FileInputStream("Models.CalendarEvents.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<CalendarEventModel> calendarEvents = (ArrayList<CalendarEventModel>) in.readObject();
            for (CalendarEventModel calEvent : calendarEvents) {
                CalendarModel flowPane = findFlowPane(calEvent.getDay(), calEvent.getMonth(), dayList);
                if (flowPane != null) {
                    System.out.println("Adding cal event " + calEvent.getName());
                    addCalendarEvents(calEvent, flowPane);
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


}


