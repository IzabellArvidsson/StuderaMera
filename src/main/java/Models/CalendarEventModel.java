package Models;

import java.io.Serializable;

/**
 * This class is the backend representation of the CalendarEvents and holds the constructor and setters and getters for it.
 * <p>
 * Used in: CalendarViewModel, EventInCalendarView
 *
 * Author: Ida
 */

public class CalendarEventModel implements Serializable {
    String name;
    String sHour;
    String sMin;
    String eHour;
    String eMin;
    String location;
    String month;
    String day;
    String description;
    String color;

    public CalendarEventModel(String name,
                              String sHour,
                              String sMin,
                              String eMin,
                              String eHour,
                              String location,
                              String month,
                              String day,
                              String description,
                              String color) {
        this.name = name;
        this.sHour = sHour;
        this.sMin = sMin;
        this.eMin = eMin;
        this.eHour = eHour;
        this.location = location;
        this.month = month;
        this.day = day;
        this.description = description;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsHour() {
        return sHour;
    }

    public String getsMin() {
        return sMin;
    }

    public String geteHour() {
        return eHour;
    }

    public String geteMin() {
        return eMin;
    }

    public String getMonth() { return month; }

    public String getDay() {
        return day;
    }

    public String getColor() {
        return color;
    }

}
