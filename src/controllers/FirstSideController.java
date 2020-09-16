package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class FirstSideController {

    @FXML private Button startstudybutton;
    @FXML private Button startplanbutton;
    @FXML private Text newuser;
    @FXML private ImageView pens;


    public void onClickStartStudy(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent timerViewParent = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml_files/TimerView.fxml")));
        Scene timerViewScene = new Scene(timerViewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(timerViewScene);
        window.show();
    }

    public void onClickStartPlaning(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent planOverviewParent = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml_files/PlanOverview.fxml")));
        Scene planOverviewScene = new Scene(planOverviewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(planOverviewScene);
        window.show();
    }
}