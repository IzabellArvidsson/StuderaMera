package ObserverInterfaces;

public interface TimerObservable {

    void register(TimerObserver timerObserver);

    void notifyObserver();
}