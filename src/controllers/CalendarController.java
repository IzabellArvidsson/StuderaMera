package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class CalendarController extends AnchorPane {

    @FXML private Button backToOverviewButton;

    public void onClickBackToOverview(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent backToOverviewParent = FXMLLoader.load(getClass().getResource("/fxml_files/PlanOverview.fxml"));
        Scene backToOverviewScene = new Scene(backToOverviewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(backToOverviewScene);
        window.show();
    }
}
