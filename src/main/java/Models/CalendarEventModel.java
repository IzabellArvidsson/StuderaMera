package Models;

import java.awt.*;
import java.util.Calendar;

public class CalendarEventModel {
    String titleText;
    String timeText;


    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public String getTimeText() {
        return timeText;
    }

    public void setTimeText(String timeText) {
        this.timeText = timeText;
    }

    public CalendarEventModel(String titleText, String timeText) {
        this.titleText = titleText;
        this.timeText = timeText;

    }

}
