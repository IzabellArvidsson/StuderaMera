package ViewControllers;

import Factory.IPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class FirstSideController implements IPane {

    private PaneController paneController = new PaneController();

    public void onClickStartStudy(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        paneController.showTimerViewPane();
    }


    public void onClickStartPlaning(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        paneController.showOverviewPane();
    }

    public void onClickGoToHelp (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        paneController.showHelpPane();
    }

    @Override
    public void initPane(PaneController paneController) {
        this.paneController = paneController;
    }
}