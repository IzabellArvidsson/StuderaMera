package Views;

import Factory.IOnClickPane;
import Factory.OnClickPaneController;
import javafx.fxml.FXML;

/**
 * Author: Hanna and Izabell
 * Uses: Factory pattern to show new views
 * Used by: None
 */
public class HelpView implements IOnClickPane {

    private OnClickPaneController onClickPaneController = new OnClickPaneController();

    /**
     * Makes sure that the view goes to FirstView when the user clicks the backButton
     */
    @FXML
    private void onClickBackButton () {
        onClickPaneController.showFirstViewPane();
    }

    /**
     * Makes sure that the view goes to the first view when the user clicks the StuderaMera-logo
     */
    @FXML
    private void onClickStuderaMera () {
        onClickPaneController.showFirstViewPane();
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