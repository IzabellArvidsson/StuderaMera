package Factory;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class OnClickPaneController {

    private AnchorPane firstViewPane;
    private AnchorPane overViewPane;
    private AnchorPane todoPane;
    private AnchorPane calendarPane;
    private AnchorPane tipsViewPane;
    private AnchorPane helpPane;
    private AnchorPane timerViewPane;

    @FXML private AnchorPane mainAnchorPane;


    public void init(){
        firstViewPane = OnClickPaneFactory.fistViewPane();
        todoPane = OnClickPaneFactory.toDoPane();
        overViewPane = OnClickPaneFactory.overviewPane();
        calendarPane = OnClickPaneFactory.calendarPane();
        tipsViewPane = OnClickPaneFactory.tipsViewPane();
        helpPane = OnClickPaneFactory.helpViewPane();
        timerViewPane = OnClickPaneFactory.timerViewPane();
        showPage(firstViewPane);
    }


    public void showFirstViewPane(){ showPage(firstViewPane);}

    public void showToDoPane(){ showPage(todoPane);}

    public void showOverviewPane(){ showPage(overViewPane);}

    public void showCalendarPane(){ showPage(calendarPane);}

    public void showTipsViewPane(){ showPage(tipsViewPane);}

    public void showHelpPane(){ showPage(helpPane);}

    public void showTimerViewPane(){  showPage(timerViewPane);}

    private void showPage(AnchorPane anchorPane){
        mainAnchorPane.getChildren().clear();
        mainAnchorPane.getChildren().add(anchorPane);
        mainAnchorPane.toFront();
    }
}
