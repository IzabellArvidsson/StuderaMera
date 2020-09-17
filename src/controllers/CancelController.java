package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CancelController {

    TimerController timerController = new TimerController();

    public void onCLickYesButton (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent timerViewParent = FXMLLoader.load(getClass().getResource("/fxml_files/TimerView.fxml"));
        Scene timerViewScene = new Scene(timerViewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(timerViewScene);
        window.show();
    }

    public void onClickNoButton (javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        Parent timerViewParent = FXMLLoader.load(getClass().getResource("/fxml_files/TimerView.fxml"));
        Scene timerViewScene = new Scene(timerViewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(timerViewScene);
        window.show();

        //timerController.TimerView.getChildren().add(timerController.timerOnView);

    }

}