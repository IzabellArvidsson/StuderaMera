package ObserverInterfaces;

import Models.ToDoListModel;

/**
 * Uses: ToDoListModel and ToDoListRemoveObservable
 * Used by: ListInToDoView by implementation
 *
 * Author: Julia
 */

public interface ToDoListRemoveObserver {

    void update(ToDoListModel toDoList, ToDoListRemoveObservable o);
}
