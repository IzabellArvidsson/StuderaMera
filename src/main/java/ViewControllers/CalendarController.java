package ViewControllers;

import Factory.IPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class CalendarController implements IPane {

    @FXML private AnchorPane addToCalendarPane;
    @FXML Text dateText;
    @FXML Button nextMonthButton, lastMonthButton;



    private PaneController paneController = new PaneController();



    public void onClickBackToOverview() {
        paneController.showOverviewPane();
    }

    public void onClickGoToHelp () {
        paneController.showHelpPane();
    }

    public void openAddToCalendar(){
        addToCalendarPane.toFront();
    }

    public void closeAddToCalendar(){
        addToCalendarPane.toBack();
    }

    @FXML
    private void onClickStuderaMera () {
        paneController.showFirstViewPane();
    }

    @Override
    public void initPane(PaneController paneController) {
        this.paneController = paneController;
    }


}
