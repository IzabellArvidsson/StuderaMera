package ViewControllers;

import Factory.IPane;
import ViewModels.ToDoListHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import java.io.IOException;


public class OverviewController implements IPane {

    public Button toCalendarButton;
    @FXML FlowPane overviewToDoFlowPane;

    private PaneController paneController = new PaneController();

    public void onClickToCalendar() {
        paneController.showCalendarPane();
    }

    public void onClickGoToHelp() {
        paneController.showHelpPane();
    }

    @FXML
    private void onClickStuderaMera() {
        paneController.showFirstViewPane();
    }

    public void onClickStartStudy(){
        paneController.showTimerViewPane();
    }

    @FXML
    public void onClickToToDo(){
        paneController.showToDoPane();
    }

    @Override
    public void initPane(PaneController paneController) {
        this.paneController = paneController;
        ToDoListHandler.writeToDoList(overviewToDoFlowPane);
    }
}

