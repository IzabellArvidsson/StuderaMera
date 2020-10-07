package ViewControllers;

import Factory.IPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class OverviewController implements IPane {

    private PaneController paneController = new PaneController();

    public void onClickToCalendar(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        paneController.showCalendarPane();
    }

    public void onClickGoToHelp(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        paneController.showHelpPane();
    }

    @FXML
    private void onClickStuderaMera(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        paneController.showFirstViewPane();
    }

    public void onClickStartStudy(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        paneController.showTimerViewPane();
    }

    @FXML
    public void onClickToToDo(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        paneController.showToDoPane();
    }

    @Override
    public void initPane(PaneController paneController) {
        this.paneController = paneController;
    }
}

