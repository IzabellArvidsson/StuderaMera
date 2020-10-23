package Factory;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

/**
 * This class initializes all the fxml-panes and shows the different pages according to the users mouse clicks
 *
 * Uses: OnClickPaneFactory
 * Used by: CalendarView, FirstSideView, HelpView, ListInToDoView, TimerView, TipsView, TodoListView and IOnClickPane
 *
 * Author: Julia
 */

public class OnClickPaneController {

    private AnchorPane firstViewPane;
    private AnchorPane todoPane;
    private AnchorPane calendarPane;
    private AnchorPane tipsViewPane;
    private AnchorPane helpPane;
    private AnchorPane timerViewPane;

    @FXML private AnchorPane mainAnchorPane;

    /**
     * This method uses variables and assigns them to different pages that can be called upon by the method showPane():
     */

    public void init(){
        firstViewPane = OnClickPaneFactory.fistViewPane();
        todoPane = OnClickPaneFactory.toDoPane();
        calendarPane = OnClickPaneFactory.calendarPane();
        tipsViewPane = OnClickPaneFactory.tipsViewPane();
        helpPane = OnClickPaneFactory.helpViewPane();
        timerViewPane = OnClickPaneFactory.timerViewPane();
        showPane(firstViewPane);
    }

    /**
     * These methods uses the method showPane() to show the desired fxml-file
     */

    public void showFirstViewPane(){ showPane(firstViewPane);}

    public void showToDoPane(){ showPane(todoPane);}

    public void showCalendarPane(){ showPane(calendarPane);}

    public void showTipsViewPane(){ showPane(tipsViewPane);}

    public void showHelpPane(){ showPane(helpPane);}

    public void showTimerViewPane(){  showPane(timerViewPane);}

    /**
     * This method shows the desired AnchorPane to the user
     *
     * @param anchorPane the pane that will be displayed in the view
     */

    private void showPane(final AnchorPane anchorPane){
        mainAnchorPane.getChildren().clear();
        mainAnchorPane.getChildren().add(anchorPane);
        mainAnchorPane.toFront();
    }
}
