package ObserverInterfaces;

/**
 * Uses: ToDoListOpenObserver
 * Used by: ToDoViewModel and ListInToDoView by implementation
 *
 * Author: Julia
 */

public interface ToDoListOpenObservable {
    void addOpen(ToDoListOpenObserver o);

    void notifyOpenObservers();
}
