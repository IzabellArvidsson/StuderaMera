package Views;

import Factory.IOnClickPane;
import Factory.OnClickPaneController;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CalendarController implements IOnClickPane {

    @FXML private AnchorPane addToCalendarPane;

    private OnClickPaneController onClickPaneController = new OnClickPaneController();

    public void onClickBackToOverview(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        onClickPaneController.showOverviewPane();
    }

    public void onClickGoToHelp (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        onClickPaneController.showHelpPane();
    }

    public void openAddToCalendar(){
        addToCalendarPane.toFront();
    }

    public void closeAddToCalendar(){
        addToCalendarPane.toBack();
    }

    @FXML
    private void onClickStuderaMera (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        onClickPaneController.showFirstViewPane();
    }

    @Override
    public void initPane(OnClickPaneController onClickPaneController) {
        this.onClickPaneController = onClickPaneController;
    }
}
