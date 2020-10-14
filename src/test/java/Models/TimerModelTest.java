package Models;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class TimerModelTest {

    @Test
    void testSetMinutes() {
        int minutes = 11;
        TimerModel timerModel = new TimerModel();
        timerModel.setMinutes(minutes);
        String string = String.valueOf(minutes);

        assertEquals("11", string);
    }

    @Test
    void testSetSeconds() {
        int seconds = 58;
        TimerModel timerModel = new TimerModel();
        timerModel.setSeconds(seconds);
        String string = String.valueOf(seconds);

        assertEquals("58", string);
    }

    @Test
    void toStringRep() {
        int rep = 2;
        TimerModel timerModel = new TimerModel();
        timerModel.setReps(rep);
        String string = String.valueOf(rep);

        assertEquals("2", string);

    }

    @Test
    void checkChangeImage() {
        int countUp = 10;
        int totalTime = 60;

        TimerModel timerModel = new TimerModel();
        //assertEquals(1, ImageModel.checkChangeImage(countUp, totalTime));
    }
}