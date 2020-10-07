package ViewControllers;

import Factory.PaneFactory;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class PaneController {

    private AnchorPane firstViewPane;
    private AnchorPane overViewPane;
    private AnchorPane todoPane;
    private AnchorPane calendarPane;
    private AnchorPane tipsViewPane;
    private AnchorPane helpPane;
    private AnchorPane timerViewPane;

    @FXML private AnchorPane mainAnchorPane;


    public void init(){
        firstViewPane = PaneFactory.fistViewPane();
        todoPane = PaneFactory.toDoPane();
        overViewPane = PaneFactory.overviewPane();
        calendarPane = PaneFactory.calendarPane();
        tipsViewPane = PaneFactory.tipsViewPane();
        helpPane = PaneFactory.helpViewPane();
        timerViewPane = PaneFactory.timerViewPane();
        showPage(firstViewPane);
    }

    void showFirstViewPane(){ showPage(firstViewPane);}

    void showToDoPane(){ showPage(todoPane);}

    void showOverviewPane(){ showPage(overViewPane);}

    void showCalendarPane(){ showPage(calendarPane);}

    void showTipsViewPane(){ showPage(tipsViewPane);}

    void showHelpPane(){ showPage(helpPane);}

    void showTimerViewPane(){  showPage(timerViewPane);}

    private void showPage(AnchorPane anchorPane){
        mainAnchorPane.getChildren().clear();
        mainAnchorPane.getChildren().add(anchorPane);
        mainAnchorPane.toFront();
    }
}
