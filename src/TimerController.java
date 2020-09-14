import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.naming.ldap.Control;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimerController extends AnchorPane {

    @FXML private AnchorPane timerOnView;
    @FXML private AnchorPane TimerView;
    @FXML private AnchorPane popupAnchorPane;

    /*public TimerController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TimerView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (
                IOException exception) {
            throw new RuntimeException(exception);
        }

        //this.controller = controller;
    }*/

    public void onClickStartTimer () {
        timerOnView.toFront();
    }

    public void onCLickStopButton (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        /*AnchorPane pane = FXMLLoader.load(getClass().getResource("CancelView.fxml"));
        popupAnchorPane.getChildren().setAll(pane);
        popupAnchorPane.toFront();*/

        Parent timerViewParent = FXMLLoader.load(getClass().getResource("CancelView.fxml"));
        Scene timerViewScene = new Scene(timerViewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(timerViewScene);
        window.show();
    }

    public void onClickGoToHelp (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent timerViewParent = FXMLLoader.load(getClass().getResource("HelpView.fxml"));
        Scene timerViewScene = new Scene(timerViewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(timerViewScene);
        window.show();
    }

}