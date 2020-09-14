import java.awt.event.ActionEvent;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class main extends Application {

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