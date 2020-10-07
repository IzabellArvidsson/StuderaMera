package Factory;

import ViewControllers.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class PaneFactory {

    private static PaneController paneController;

    private static <T> Pane<T> loadInPane(String path) {
        Pane<T> pane = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PaneFactory.class.getClassLoader().getResource(path));
            AnchorPane anchorPane = fxmlLoader.load();
            T controller = fxmlLoader.getController();
            pane = new Pane<T>(anchorPane, controller);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return pane;
    }


    public static Parent mainPane(){
        Pane<PaneController> pane = loadInPane("fxml_files/mainAnchorPane.fxml");
        PaneFactory.paneController = pane.controller;
        pane.controller.init();
        return pane.aPane;
    }

    public static AnchorPane fistViewPane(){
        Pane<FirstSideController> pane = loadInPane("fxml_files/firstSideView.fxml");
        pane.controller.initPane(paneController);
        return pane.aPane;
    }

    public static AnchorPane toDoPane(){
        Pane <TodoController> pane = loadInPane("fxml_files/todo.fxml");
        pane.controller.initPane(paneController);
        return pane.aPane;
    }

    public static AnchorPane calendarPane(){
        Pane <CalendarController> pane = loadInPane("fxml_files/Calendar.fxml");
        pane.controller.initPane(paneController);
        return pane.aPane;
    }

    public static AnchorPane overviewPane(){
        Pane <OverviewController> pane = loadInPane("fxml_files/PlanOverview.fxml");
        pane.controller.initPane(paneController);
        return pane.aPane;
    }

    public static AnchorPane tipsViewPane(){
        Pane <TipsViewController> pane = loadInPane("fxml_files/TipsView.fxml");
        pane.controller.initPane(paneController);
        return pane.aPane;
    }

    public static AnchorPane helpViewPane(){
        Pane <HelpViewController> pane = loadInPane("fxml_files/HelpView.fxml");
        pane.controller.initPane(paneController);
        return pane.aPane;
    }

    public static AnchorPane timerViewPane(){
        Pane <TimerViewController> pane = loadInPane("fxml_files/TimerView.fxml");
        pane.controller.initPane(paneController);
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
