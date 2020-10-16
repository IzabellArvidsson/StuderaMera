package ObserverInterfaces;

import Models.TimerModel;

public interface TimerObserver {

    void update(int time, int reps, String string, int currentRep, boolean stopped, int countUp);
    void update(TimerModel timer);

}