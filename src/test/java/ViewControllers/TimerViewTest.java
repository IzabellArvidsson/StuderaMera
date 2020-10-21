package ViewControllers;

import ViewModels.ImageViewModel;
import Views.TimerView;
import org.junit.jupiter.api.Test;

class TimerViewTest {

    @Test
    void testImageLoader() {
        TimerView timerView = new TimerView();
        ImageViewModel imageModel = new ImageViewModel();
        int countUp = 10;
        int totalTime = 70;

        int i = imageModel.checkChangeImage(countUp, totalTime);

        //timerView.
    }

}