package Factory;

import Views.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class OnClickPaneFactory {

    private static OnClickPaneController onClickPaneController;

    private static <T> Pane<T> loadInPane(String path) {
        Pane<T> pane = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(OnClickPaneFactory.class.getClassLoader().getResource(path));
            AnchorPane anchorPane = fxmlLoader.load();
            T controller = fxmlLoader.getController();
            pane = new Pane<T>(anchorPane, controller);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return pane;
    }


    public static Parent mainPane(){
        Pane<OnClickPaneController> pane = loadInPane("fxml_files/mainAnchorPane.fxml");
        OnClickPaneFactory.onClickPaneController = pane.controller;
        pane.controller.init();
        return pane.aPane;
    }

    public static AnchorPane fistViewPane(){
        Pane<FirstSideController> pane = loadInPane("fxml_files/firstSideView.fxml");
        pane.controller.initPane(onClickPaneController);
        return pane.aPane;
    }

    public static AnchorPane toDoPane(){
        Pane <TodoListView> pane = loadInPane("fxml_files/todo.fxml");
        pane.controller.initPane(onClickPaneController);
        return pane.aPane;
    }

    public static AnchorPane calendarPane(){
        Pane <CalendarController> pane = loadInPane("fxml_files/Calendar.fxml");
        pane.controller.initPane(onClickPaneController);
        return pane.aPane;
    }

    public static AnchorPane overviewPane(){
        Pane <OverviewView> pane = loadInPane("fxml_files/PlanOverview.fxml");
        pane.controller.initPane(onClickPaneController);
        return pane.aPane;
    }

    public static AnchorPane tipsViewPane(){
        Pane <TipsViewController> pane = loadInPane("fxml_files/TipsView.fxml");
        pane.controller.initPane(onClickPaneController);
        return pane.aPane;
    }

    public static AnchorPane helpViewPane(){
        Pane <HelpViewController> pane = loadInPane("fxml_files/HelpView.fxml");
        pane.controller.initPane(onClickPaneController);
        return pane.aPane;
    }

    public static AnchorPane timerViewPane(){
        Pane <TimerViewController> pane = loadInPane("fxml_files/TimerView.fxml");
        pane.controller.initPane(onClickPaneController);
        return pane.aPane;
    }


    static class Pane<T> {
        AnchorPane aPane;
        T controller;
        Pane(AnchorPane anchorPane, T controller) {
            this.aPane = anchorPane;
            this.controller = controller;
        }
    }


}
