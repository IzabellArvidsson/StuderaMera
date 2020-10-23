package Views;

import Factory.IOnClickPane;
import Factory.OnClickPaneController;
import javafx.fxml.FXML;

/**
 * Author: Hanna and Izabell
 * Uses: Factory pattern to show new views
 * Used by: None
 */
public class TipsView implements IOnClickPane {

    private OnClickPaneController onClickPaneController = new OnClickPaneController();

    /**
     * Makes sure that the view goes to TimerView when the user clicks the backbutton
     */
    @FXML
    private void onClickBackButton () {
        onClickPaneController.showTimerViewPane();
    }

    /**
     * Makes sure that the view goes to the first side when the user clicks the StuderaMera-logo
     */
    @FXML
    private void onClickStuderaMera () {
        onClickPaneController.showFirstViewPane();
    }

    /**
     * Makes sure that the view goes to helpview when the user clicks the help-button
     */
    @FXML
    private void onClickGoToHelp () {
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