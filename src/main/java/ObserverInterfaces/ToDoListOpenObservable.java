package ObserverInterfaces;

public interface ToDoListOpenObservable {
    void addOpen(ToDoListOpenObserver o);

    void notifyOpenObservers();
}
