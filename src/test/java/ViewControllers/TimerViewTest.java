package ViewControllers;

import Models.ImageModel;
import Views.TimerView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimerViewTest {

    @Test
    void testImageLoader() {
        TimerView timerView = new TimerView();
        ImageModel imageModel = new ImageModel();
        int countUp = 10;
        int totalTime = 70;

        int i = imageModel.checkChangeImage(countUp, totalTime);

        //timerView.
    }

}