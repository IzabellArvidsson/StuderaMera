package ObserverInterfaces;

public interface TimerObserver {

    void update(int reps, String string, int currentRep, boolean stopped, int countUp);
    void update(String time);

}