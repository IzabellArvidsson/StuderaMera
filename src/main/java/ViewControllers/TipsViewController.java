package ViewControllers;

import Factory.IPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TipsViewController implements IPane {

    private PaneController paneController = new PaneController();

    @FXML
    private void onClickBackButton (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        paneController.showTimerViewPane();
    }

    @FXML
    private void onClickStuderaMera (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        paneController.showFirstViewPane();
    }

    public void onClickGoToHelp (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        paneController.showHelpPane();
    }


    @Override
    public void initPane(PaneController paneController) {
        this.paneController = paneController;
    }
}