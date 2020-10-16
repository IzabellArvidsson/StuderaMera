package ObserverInterfaces;

public interface CalendarObservable {

        void addObserver(CalendarObserver calendarObserver);

        void notifyObserver();
    }
