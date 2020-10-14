package ObserverInterfaces;

public interface ToDoListRemoveObservable {

    void add(ToDoListRemoveObserver o);

    void notifyObservers();
}
