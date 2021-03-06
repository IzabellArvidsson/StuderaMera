package Factory;

import Views.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * This class is used as a factory for all the panes in the fxml-files
 *
 * Uses: OnClickPaneController
 * Used by: OnClickPaneController
 *
 * Author: Julia
 */

public class OnClickPaneFactory {

    private static OnClickPaneController onClickPaneController;

    /**
     * This method gets the root and the controller for the function that called upon it
     *
     * @param path the path to the fxml-file
     * @param <T> the generic type from the Pane <T> class
     * @return a pane that contains a controller and a anchorPane
     */

    private static <T> Pane<T> loadInPane(final String path) {
        Pane<T> pane = null;
        try {
            final FXMLLoader fxmlLoader = new FXMLLoader(OnClickPaneFactory.class.getClassLoader().getResource(path));
            final AnchorPane anchorPane = fxmlLoader.load();
            final T controller = fxmlLoader.getController();
            pane = new Pane<T>(anchorPane, controller);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return pane;
    }

    /**
     * These methods loads the desired fxml-file
     *
     * @return the desired pane
     */


    public static Parent mainPane(){
        final Pane<OnClickPaneController> pane = loadInPane("fxml_files/mainAnchorPane.fxml");
        OnClickPaneFactory.onClickPaneController = pane.controller;
        pane.controller.init();
        return pane.aPane;
    }

    public static AnchorPane fistViewPane(){
        final Pane<FirstSideView> pane = loadInPane("fxml_files/firstSideView.fxml");
        pane.controller.initPane(onClickPaneController);
        return pane.aPane;
    }

    public static AnchorPane toDoPane(){
        final Pane <TodoListView> pane = loadInPane("fxml_files/todo.fxml");
        pane.controller.initPane(onClickPaneController);
        return pane.aPane;
    }

    public static AnchorPane calendarPane(){
        final Pane <CalendarView> pane = loadInPane("fxml_files/Calendar.fxml");
        pane.controller.initPane(onClickPaneController);
        return pane.aPane;
    }

    public static AnchorPane tipsViewPane(){
        final Pane <TipsView> pane = loadInPane("fxml_files/TipsView.fxml");
        pane.controller.initPane(onClickPaneController);
        return pane.aPane;
    }

    public static AnchorPane helpViewPane(){
        final Pane <HelpView> pane = loadInPane("fxml_files/HelpView.fxml");
        pane.controller.initPane(onClickPaneController);
        return pane.aPane;
    }

    public static AnchorPane timerViewPane(){
        final Pane <TimerView> pane = loadInPane("fxml_files/TimerView.fxml");
        pane.controller.initPane(onClickPaneController);
        return pane.aPane;
    }

    /**
     * This class allows us to store a controller and pane from a fxml-file as one
     *
     * @param <T> the generic type of the class
     */

    static class Pane<T> {
        private final AnchorPane aPane;
        private final T controller;
        Pane(final AnchorPane anchorPane, final T controller) {
            this.aPane = anchorPane;
            this.controller = controller;
        }
    }


}
