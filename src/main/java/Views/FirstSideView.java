package Views;

import Factory.IOnClickPane;
import Factory.OnClickPaneController;

public class FirstSideView implements IOnClickPane {

    private OnClickPaneController onClickPaneController = new OnClickPaneController();

    public void onClickStartStudy() {
        onClickPaneController.showTimerViewPane();
    }

    public void onClickToCalendar(){
        onClickPaneController.showCalendarPane();
    }

    public void onClickToTodoList(){
        onClickPaneController.showToDoPane();
    }

    public void onClickGoToHelp (){
        onClickPaneController.showHelpPane();
    }

    @Override
    public void initPane(OnClickPaneController onClickPaneController) {
        this.onClickPaneController = onClickPaneController;
    }
}