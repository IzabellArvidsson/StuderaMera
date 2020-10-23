package ObserverInterfaces;

/**
 * Author: Hanna and Izabell
 * Uses: TimerObserver to register classes
 * Used by: TimerViewModel uses this interface to register its class
 *
 */
public interface TimerObservable {

    void register(TimerObserver timerObserver);

    void notifyObserver();
}