package ObserverInterfaces;

/**
 * Uses: ToDoListRemoveObserver
 * Used by: ToDoViewModel and ListInToDoView by implementation
 *
 * Author: Julia
 */

public interface ToDoListRemoveObservable {

    void add(ToDoListRemoveObserver o);

    void notifyObservers();
}
