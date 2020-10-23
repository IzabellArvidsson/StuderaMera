package ObserverInterfaces;

/**
 * Uses: ToDoListRemoveObserver
 * Used by: ListInToDoView
 *
 * Author: Julia
 */

public interface ToDoListRemoveObservable {

    void add(ToDoListRemoveObserver o);

    void notifyObservers();
}
