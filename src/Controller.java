import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML private Button startstudybutton;
    @FXML private AnchorPane TimerView;
    @FXML private AnchorPane firstView;



    @FXML
    private void onClickStartStudy(javafx.event.ActionEvent event) throws IOException {
         Parent timerViewParent = FXMLLoader.load(getClass().getResource("TimerView.fxml"));
         Scene timerViewScene = new Scene(timerViewParent);

         Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
         window.setScene(timerViewScene);
         window.show();
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}