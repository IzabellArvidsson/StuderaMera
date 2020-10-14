package Models;

/**
 * Handles the model functionality of the images
 */
public class ImageModel {

    public int countUp;

    /**
     * Checks if it is time to change the image and returns the number of the image
     * @param countUp How many seconds that has passed of the study time
     * @param totalTime The total amount of study seconds
     * @return The number which represent the picture the view should change to
     */
    public int checkChangeImage(int countUp, int totalTime) {
        int numberOfImages = 7;
        int divideTotalTime = totalTime / numberOfImages;

        if(countUp == divideTotalTime) {
            return 1;
        }
        else if(countUp == 2 * divideTotalTime) {
            return 2;
        }
        else if(countUp == 3 * divideTotalTime) {
            return 3;
        }
        else if(countUp == 4 * divideTotalTime) {
            return 4;
        }
        else if(countUp == 5 * divideTotalTime) {
            return 5;
        }
        else if(countUp == 6 * divideTotalTime) {
            return 6;
        }
        else { return 0; }
    }
}
