package Models;

import javafx.scene.Node;
import javafx.scene.layout.FlowPane;

import java.time.LocalDate;
import java.time.YearMonth;

public class CalendarModel extends FlowPane {

    private LocalDate localDate;
    private YearMonth month;

    public YearMonth getMonth() {
        return month;
    }

    public void setMonth(YearMonth month) {
        this.month = month;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public CalendarModel (Node... children){
        super(children);
    }
}
