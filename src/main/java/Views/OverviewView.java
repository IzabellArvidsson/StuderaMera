package Views;

import Factory.IOnClickPane;
import Factory.OnClickPaneController;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;


public class OverviewView implements IOnClickPane {


    @FXML FlowPane overviewToDoFlowPane;

    private OnClickPaneController onClickPaneController = new OnClickPaneController();


    public void onClickToCalendar() {
        onClickPaneController.showCalendarPane();
    }

    public void onClickGoToHelp() {
        onClickPaneController.showHelpPane();
    }

    @FXML
    private void onClickStuderaMera() { onClickPaneController.showFirstViewPane(); }

    public void onClickStartStudy(){
        onClickPaneController.showTimerViewPane();
    }

    @FXML
    public void onClickToToDo(){
        onClickPaneController.showToDoPane();
    }


    @Override
    public void initPane(OnClickPaneController onClickPaneController) {
        this.onClickPaneController = onClickPaneController;
    }

}

