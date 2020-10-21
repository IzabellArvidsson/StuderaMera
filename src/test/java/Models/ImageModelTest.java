package Models;

import ViewModels.ImageViewModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageModelTest {

    @Test
    void checkChangeImage() {
        ImageViewModel imageModel = new ImageViewModel();
        int countUp = 10;
        int totalTime = 70;

        int i = imageModel.checkChangeImage(countUp, totalTime);

        assertEquals(1, i);
    }
}