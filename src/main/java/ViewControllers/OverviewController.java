package ViewControllers;

import Factory.IPane;
import ViewModels.ToDoListHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;


public class OverviewController implements IPane{


    @FXML FlowPane overviewToDoFlowPane;

    private PaneController paneController = new PaneController();


    public void onClickToCalendar() {
        paneController.showCalendarPane();
    }

    public void onClickGoToHelp() {
        paneController.showHelpPane();
    }

    @FXML
    private void onClickStuderaMera() { paneController.showFirstViewPane(); }

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
        String id = "no";
        //ToDoListHandler.writeToDoList(overviewToDoFlowPane, id);
    }

}

