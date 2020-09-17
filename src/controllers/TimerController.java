package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TimerController extends AnchorPane {

    @FXML private AnchorPane timerOnView;
    @FXML private AnchorPane TimerView;


    public void onClickStartTimer () {
        timerOnView.toFront();
    }

    public void onCLickStopButton (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        /*AnchorPane pane = FXMLLoader.load(getClass().getResource("CancelView.fxml"));
        hhhh.getChildren().setAll(pane);
        hhhh.toFront();*/

        Parent timerViewParent = FXMLLoader.load(getClass().getResource("/fxml_files/CancelView.fxml"));
        Scene timerViewScene = new Scene(timerViewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(timerViewScene);
        window.show();
    }

    public void onClickGoToHelp (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent timerViewParent = FXMLLoader.load(getClass().getResource("/fxml_files/HelpView.fxml"));
        Scene timerViewScene = new Scene(timerViewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(timerViewScene);
        window.show();
    }

}