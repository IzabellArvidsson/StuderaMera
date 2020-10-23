package Models;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 * Testing class for the timerModel class
 */
class TimerModelTest {

    /**
     * Testing the setReps() function
     */
    @Test
    void testSetReps() {
        int reps = 2;
        TimerModel timerModel = new TimerModel();
        timerModel.setReps(reps);

        assertEquals("2", timerModel.getReps());
    }

    /**
     * Testing the setMinutes() function
     */
    @Test
    void testSetMinutes() {
        int minutes = 11;
        TimerModel timerModel = new TimerModel();
        timerModel.setMinutes(minutes);
        String string = String.valueOf(minutes);

        assertEquals("11", string);
    }

    /**
     * Testing the setSeconds() function
     */
    @Test
    void testSetSeconds() {
        int seconds = 58;
        TimerModel timerModel = new TimerModel();
        timerModel.setSeconds(seconds);
        String string = String.valueOf(seconds);

        assertEquals("58", string);
    }

    /**
     * Testing the getMinutes() function
     */
    @Test
    void testGetMinutes() {
        int minutes = 2;
        TimerModel timerModel = new TimerModel();
        timerModel.setMinutes(minutes);

        assertEquals(2, Integer.parseInt(timerModel.getMinutes()));

    }

    /**
     * Testing the getSeconds() function
     */
    @Test
    void testGetSeconds() {
        int seconds = 59;
        TimerModel timerModel = new TimerModel();
        timerModel.setSeconds(seconds);

        assertEquals(59, Integer.parseInt(timerModel.getSeconds()));
    }

    /**
     * Testing the getReps() function
     */
    @Test
    void testGetReps() {
        int reps = 2;
        TimerModel timerModel = new TimerModel();
        timerModel.setReps(reps);

        assertEquals(2, Integer.parseInt(timerModel.getReps()));
    }

    /**
     * Testing the toString() function
     */
    @Test
    void testToString() {
        int minutes = 2;
        int seconds = 59;
        TimerModel timerModel = new TimerModel();
        timerModel.setMinutes(minutes);
        timerModel.setSeconds(seconds);

        assertEquals("2:59", timerModel.toString());

    }
}