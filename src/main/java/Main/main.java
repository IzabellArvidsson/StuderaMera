package Main;
import Factory.OnClickPaneFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

   @Override
    public void start(final Stage stage) {
       final Scene scene = new Scene(OnClickPaneFactory.mainPane(), 936, 624);
       stage.setTitle("StuderaMera");
       stage.setResizable(false);
       stage.setScene(scene);
       stage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}