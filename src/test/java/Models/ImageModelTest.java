package Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageModelTest {

    @Test
    void checkChangeImage() {
        ImageModel imageModel = new ImageModel();
        int countUp = 10;
        int totalTime = 70;

        int i = imageModel.checkChangeImage(countUp, totalTime);

        assertEquals(1, i);
    }
}