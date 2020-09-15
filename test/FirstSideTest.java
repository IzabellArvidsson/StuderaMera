import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FirstSideTest {

    @Test
    public void testOnClickStartStudy(MouseEvent mouseEvent) throws IOException {
        AnchorPane expected;

        FirstSide firstSide = new FirstSide();
        firstSide.onClickStartStudy(mouseEvent);

        //ssertSame(firstSide.onClickStartStudy(mouseEvent), "TimerView.fxml");
    }
}