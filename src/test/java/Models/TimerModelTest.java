package Models;

import javafx.scene.control.Label;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class TimerModelTest {


    @Test
    void testToString() {

        TimerModel timerModel = new TimerModel();

        //assertEquals(timerModel.getMinutes() +":"+ timerModel.getSeconds(), timerModel.toString());
        assertEquals("00:00", timerModel.toString());
    }

    @Test
    void setMinutes() {
        int minutes = 11;
        TimerModel timerModel = new TimerModel();
        timerModel.setMinutes(minutes);

        assertEquals("11", timerModel.getMinutes());

    }

    @Test
    void setSeconds() {
        int seconds = 58;
        TimerModel timerModel = new TimerModel();
        timerModel.setSeconds(seconds);

        assertEquals("58", timerModel.getSeconds());

    }
}