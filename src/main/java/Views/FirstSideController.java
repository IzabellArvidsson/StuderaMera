package Views;

import Factory.IOnClickPane;
import Factory.OnClickPaneController;

import java.io.IOException;

public class FirstSideController implements IOnClickPane {

    private OnClickPaneController onClickPaneController = new OnClickPaneController();

    public void onClickStartStudy(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        onClickPaneController.showTimerViewPane();
    }


    public void onClickStartPlaning(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        onClickPaneController.showOverviewPane();
    }

    public void onClickGoToHelp (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        onClickPaneController.showHelpPane();
    }

    @Override
    public void initPane(OnClickPaneController onClickPaneController) {
        this.onClickPaneController = onClickPaneController;
    }
}