import java.awt.*;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class main extends Application {

   /* @FXML private Button startstudybutton;
    @FXML private Button startplanbutton;
    @FXML private Text newuser;
    @FXML private ImageView pens;*/


   @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("helloWorld.fxml"));
        stage.setTitle("StuderaMera");
        Scene scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);

        System.out.println("Hello world");

    }

}