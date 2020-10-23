package ViewModels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the ImageViewModel class
 */
class ImageViewModelTest {

    /**
     * Testing the checkChangeImage() function
     */
    @Test
    void checkChangeImage() {
        ImageViewModel imageModel = new ImageViewModel();
        int countUp = 10;
        int totalTime = 70;

        int i = imageModel.checkChangeImage(countUp, totalTime);

        assertEquals(1, i);
    }
}