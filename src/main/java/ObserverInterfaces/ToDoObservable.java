package ObserverInterfaces;

public interface ToDoObservable {

    void addObserver(ToDoObserver toDoObserver);

    void notifyObserver();
}
