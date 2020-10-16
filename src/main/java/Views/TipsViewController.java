package Views;

import Factory.IOnClickPane;
import Factory.OnClickPaneController;
import javafx.fxml.FXML;

import java.io.IOException;

public class TipsViewController implements IOnClickPane {

    private OnClickPaneController onClickPaneController = new OnClickPaneController();

    @FXML
    private void onClickBackButton (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        onClickPaneController.showTimerViewPane();
    }

    @FXML
    private void onClickStuderaMera (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        onClickPaneController.showFirstViewPane();
    }

    public void onClickGoToHelp (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        onClickPaneController.showHelpPane();
    }


    @Override
    public void initPane(OnClickPaneController onClickPaneController) {
        this.onClickPaneController = onClickPaneController;
    }
}