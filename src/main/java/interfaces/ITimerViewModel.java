package interfaces;

import ObserverInterfaces.TimerObserver;

/**
 * Author: Hanna
 * Used by: TimerViewModel to use information
 * Uses: TimerView to get information
 * Interface to avoid a strong dependency between TimerView and TimerViewModel
 */
public interface ITimerViewModel {

    void setStudyTimerSpinner(Object studyTime);
    void setRestTimerSpinner(Object restTime);
    void setRepTimerSpinner(Object repNumber);

    void setCountUpInt();
    void setTimelines();

    void startStudyTime();
    void pauseStudyTime();
    void stopStudyTime();
    void playStudyTime();

    void register(TimerObserver observer);
}
