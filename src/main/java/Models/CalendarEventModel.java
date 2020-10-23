package Models;

import java.io.Serializable;

/**
 * This class is the backend representation of the CalendarEvents and holds the constructor and setters and getters for it.
 *
 * Used in: CalendarViewModel, Calendar
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

    public void setsHour(String sHour) {
        this.sHour = sHour;
    }

    public String getsMin() {
        return sMin;
    }

    public void setsMin(String sMin) {
        this.sMin = sMin;
    }

    public String geteHour() {
        return eHour;
    }

    public void seteHour(String eHour) {
        this.eHour = eHour;
    }

    public String geteMin() {
        return eMin;
    }

    public void seteMin(String eMin) {
        this.eMin = eMin;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
