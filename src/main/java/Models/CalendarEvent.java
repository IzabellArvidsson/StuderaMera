package Models;

import java.awt.*;
import java.util.Calendar;

public class CalendarEvent {
    String name;
    String hour;
    String min;
    String place;
    String year;
    String month;
    String day;
    String description;
    Color color;

    public CalendarEvent(String name, String hour, String min, String place, String year, String month, String day, String description, Color color) {
        this.name = name;
        this.hour = hour;
        this.min = min;
        this.place = place;
        this.year = year;
        this.month = month;
        this.day = day;
        this.description = description;
        this.color = color;
    }
}
