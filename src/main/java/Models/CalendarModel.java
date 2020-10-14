package Models;

import javafx.scene.Node;
import javafx.scene.layout.FlowPane;

import java.time.LocalDate;

public class CalendarModel extends FlowPane {


    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    private LocalDate localDate;

    public CalendarModel (Node... children){
        super(children);

    }

}
