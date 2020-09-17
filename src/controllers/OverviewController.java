package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


public class OverviewController extends AnchorPane{

    @FXML private Button toCalendarButton;
    @FXML private AnchorPane calendarPane;

    public void onClickToCalendar(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent toCalendarParent = FXMLLoader.load(getClass().getResource("fxml_files/Calendar.fxml"));
        Scene toCalendarScene = new Scene(toCalendarParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(toCalendarScene);
        window.show();
    }
}
