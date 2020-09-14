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

public class TimerController extends AnchorPane {

    @FXML private AnchorPane timerOnView;

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

    public void onCLickStopButton () {
        timerOnView.toBack();
    }

    public void onClickGoToHelp (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent timerViewParent = FXMLLoader.load(getClass().getResource("HelpView.fxml"));
        Scene timerViewScene = new Scene(timerViewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(timerViewScene);
        window.show();
    }

}