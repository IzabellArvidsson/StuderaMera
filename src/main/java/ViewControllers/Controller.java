package ViewControllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Controller {


    public void onClickButton (javafx.scene.input.MouseEvent mouseEvent, String fxml) throws IOException {
        Parent timerViewParent = FXMLLoader.load(getClass().getResource(fxml));
        Scene timerViewScene = new Scene(timerViewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(timerViewScene);
        window.show();
    }

}