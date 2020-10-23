package ObserverInterfaces;

/**
 * Author: Hanna and Izabell
 * Uses: None
 * Used by: TimerObservable uses this class for register method. ITimerViewModel uses this class for register model.
 * TimerViewModel and TimerView implements this interface.
 *
 */
public interface TimerObserver {

    void update(int reps, String string, int currentRep, boolean stopped, int countUp);
    void update(String time);

}