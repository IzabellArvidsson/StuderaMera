package Models;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class TimerModelTest {

    @Test
    void testSetReps() {
        int reps = 2;
        TimerModel timerModel = new TimerModel();
        timerModel.setReps(reps);

        assertEquals("2", timerModel.getReps());
    }

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
    void testGetMinutes() {
        int minutes = 2;
        TimerModel timerModel = new TimerModel();
        timerModel.setMinutes(minutes);

        assertEquals(2, Integer.parseInt(timerModel.getMinutes()));

    }

    @Test
    void testGetSeconds() {
        int seconds = 59;
        TimerModel timerModel = new TimerModel();
        timerModel.setSeconds(seconds);

        assertEquals(59, Integer.parseInt(timerModel.getSeconds()));
    }

    @Test
    void testGetReps() {
        int reps = 2;
        TimerModel timerModel = new TimerModel();
        timerModel.setReps(reps);

        assertEquals(2, Integer.parseInt(timerModel.getReps()));
    }

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