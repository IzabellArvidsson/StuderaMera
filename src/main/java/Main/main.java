package Main;
import Factory.PaneFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

   @Override
    public void start(Stage stage) {
       Scene scene = new Scene(PaneFactory.mainPane(), 936, 624);
       stage.setTitle("StuderaMera");
       stage.setResizable(false);
       stage.setScene(scene);
       stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}