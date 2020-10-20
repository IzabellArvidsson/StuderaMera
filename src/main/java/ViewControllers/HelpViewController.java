package ViewControllers;

import Factory.IPane;
import javafx.fxml.FXML;

import java.io.IOException;

public class HelpViewController implements IPane {

    private PaneController paneController = new PaneController();


    @FXML
    private void onClickBackButton(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        paneController.showTimerViewPane();
    }

    @FXML
    private void onClickStuderaMera(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        paneController.showFirstViewPane();
    }

    @Override
    public void initPane(PaneController paneController) {
        this.paneController = paneController;
    }
}