import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class FirstSide {

    @FXML private Button startstudybutton;
    @FXML private Button startplanbutton;
    @FXML private Text newuser;
    @FXML private ImageView pens;

    /*public FirstSide(Button startstudybutton, Button startplanbutton, Text newuser, ImageView pens) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("helloWorld.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        } catch (IOException exception){
            throw new RuntimeException(exception);
        }

        this.startstudybutton = startstudybutton;
        this.startplanbutton = startplanbutton;
        this.newuser = newuser;
        this.pens = pens;
    }*/

    public void onClickStartStudy(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent timerViewParent = FXMLLoader.load(getClass().getResource("TimerView.fxml"));
        Scene timerViewScene = new Scene(timerViewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(timerViewScene);
        window.show();
    }

    public void onClickStartPlaning(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent planOverviewParent = FXMLLoader.load(getClass().getResource("PlanOverview.fxml"));
        Scene planOverviewScene = new Scene(planOverviewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(planOverviewScene);
        window.show();
    }
}