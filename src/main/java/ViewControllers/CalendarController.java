package ViewControllers;

import Factory.IPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class CalendarController implements IPane  {

    @FXML private AnchorPane addToCalendarPane;

    private PaneController paneController = new PaneController();

    public void onClickBackToOverview(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        paneController.showOverviewPane();
    }

    public void onClickGoToHelp (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        paneController.showHelpPane();
    }

    public void openAddToCalendar(){
        addToCalendarPane.toFront();
    }

    public void closeAddToCalendar(){
        addToCalendarPane.toBack();
    }

    @FXML
    private void onClickStuderaMera (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        paneController.showFirstViewPane();
    }

    @Override
    public void initPane(PaneController paneController) {
        this.paneController = paneController;
    }
}
