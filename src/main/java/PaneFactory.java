import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class PaneFactory {

    private static PaneController paneController;

    private static <T> Pane<T> loadInPane(String path) {
        Pane<T> pane = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PaneFactory.class.getClassLoader().getResource(path));
            AnchorPane anchorPane = fxmlLoader.load();
            T controller = fxmlLoader.getController();
            pane = new Pane<T>(anchorPane, controller);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return pane;
    }


    public static Parent mainPane(){
        Pane<PaneController> pane = loadInPane("/fxml_files/firstSideView.fxml");
        PaneFactory.paneController = pane.controller;
        pane.controller.init();
        return pane.aPane;
    }

    static AnchorPane fistViewPane(){
        Pane<PaneController> pane = loadInPane("/fxml_files/firstSideView.fxml");
        //pane.controller.
        return pane.aPane;
    }





    static class Pane<T> {
        AnchorPane aPane;
        T controller;
        Pane(AnchorPane anchorPane, T controller) {
            this.aPane = anchorPane;
            this.controller = controller;
        }
    }


}
