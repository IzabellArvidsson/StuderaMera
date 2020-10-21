package Views;

import Factory.IOnClickPane;
import Factory.OnClickPaneController;
import javafx.fxml.FXML;

public class TipsView implements IOnClickPane {

    private OnClickPaneController onClickPaneController = new OnClickPaneController();

    @FXML
    private void onClickBackButton () {
        onClickPaneController.showTimerViewPane();
    }

    @FXML
    private void onClickStuderaMera () {
        onClickPaneController.showFirstViewPane();
    }

    public void onClickGoToHelp () {
        onClickPaneController.showHelpPane();
    }

    @Override
    public void initPane(OnClickPaneController onClickPaneController) {
        this.onClickPaneController = onClickPaneController;
    }
}