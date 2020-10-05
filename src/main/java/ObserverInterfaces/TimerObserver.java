package ObserverInterfaces;

import Models.TimerModel;

public interface TimerObserver {

    void update(int time);
    void update(TimerModel timer);
}