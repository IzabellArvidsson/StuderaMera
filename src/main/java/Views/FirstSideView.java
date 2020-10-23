package Views;

import Factory.IOnClickPane;
import Factory.OnClickPaneController;
import javafx.fxml.FXML;

/**
 * Author: Hanna and Izabell
 * Uses: Factory pattern to show new views
 * Used by: None
 */
public class FirstSideView implements IOnClickPane {

    private OnClickPaneController onClickPaneController = new OnClickPaneController();

    /**
     * Makes sure that the view goes to TimerView when the user clicks the startstudybutton
     */
    @FXML
    private void onClickStartStudy() {
        onClickPaneController.showTimerViewPane();
    }

    /**
     * Makes sure that the view goes to CalenderView when the user clicks the "go to calendar"-button
     */
    @FXML
    private void onClickToCalendar(){
        onClickPaneController.showCalendarPane();
    }

    /**
     * Makes sure that the view goes to ToDoView when the user clicks the "go to toDo"-button
     */
    @FXML
    private void onClickToTodoList(){
        onClickPaneController.showToDoPane();
    }

    /**
     * Makes sure that the view goes to HelpView when the user clicks the "help"-button
     */
    @FXML
    private void onClickGoToHelp (){
        onClickPaneController.showHelpPane();
    }

    /**
     * Initializes the Factory pattern
     * @param onClickPaneController the class that controls the factory pattern
     */
    @Override
    public void initPane(OnClickPaneController onClickPaneController) {
        this.onClickPaneController = onClickPaneController;
    }
}