package ObserverInterfaces;

/**
 * Uses: ToDoListRemoveObservable
 * Used by: ToDoListView by implementation
 *
 * Author: Julia
 */

public interface ToDoListRemoveObserver {

    void update(String name, ToDoListRemoveObservable o);
}
