package Views;

import Factory.IOnClickPane;
import Factory.OnClickPaneController;
import javafx.fxml.FXML;

import java.io.IOException;

public class HelpViewController implements IOnClickPane {

    private OnClickPaneController onClickPaneController = new OnClickPaneController();

    /*@Override
    public void onClickButton(MouseEvent mouseEvent, String fxml) throws IOException {
        super.onClickButton(mouseEvent, "/fxml_files/TimerView.fxml");
    }*/

    @FXML
    private void onClickBackButton (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        onClickPaneController.showTimerViewPane();
    }

    @FXML
    private void onClickStuderaMera (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        onClickPaneController.showFirstViewPane();
    }

    @Override
    public void initPane(OnClickPaneController onClickPaneController) {
        this.onClickPaneController = onClickPaneController;
    }
}