package Models;

import java.awt.*;
import java.io.Serializable;
import java.util.Calendar;

public class CalendarEvent implements Serializable {
    String name;
    String sHour;
    String sMin;
    String eHour;
    String eMin;
    String place;
    String year;
    String month;
    String day;
    String description;
    Color color;

    public CalendarEvent(String name, String sHour, String sMin, String eMin, String eHour, /*String place,*/ String year, String month, String day/*, String description,Color color*/ ) {
        this.name = name;
        this.sHour = sHour;
        this.sMin = sMin;
        this.eMin = eMin;
        this.eHour = eHour;
        //this.place = place;
        this.year = year;
        this.month = month;
        this.day = day;
        //this.description = description;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
