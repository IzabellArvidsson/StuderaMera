package models;

import java.util.Calendar;

public class CalendarEvent {
    String name;
    int time;
    String place;
    Calendar date;


    public CalendarEvent(String name, int time) {
        this.name = name;
        this.time = time;
    }
}
