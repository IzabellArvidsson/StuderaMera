import controllers.FirstSideController;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.junit.Test;

import java.io.IOException;

class FirstSideTest {

    @Test
    public void testOnClickStartStudy(MouseEvent mouseEvent) throws IOException {
        AnchorPane expected;

        FirstSideController firstSideController = new FirstSideController();
        firstSideController.onClickStartStudy(mouseEvent);

        //ssertSame(firstSide.onClickStartStudy(mouseEvent), "TimerView.fxml");
    }
}