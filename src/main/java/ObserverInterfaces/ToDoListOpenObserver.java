package ObserverInterfaces;

import Models.ToDoListModel;

/**
 * Uses: ToDoListModel
 * Used by: ListInToDoView by implementation
 *
 * Author: Julia
 */

public interface ToDoListOpenObserver {
    void updateOpen(ToDoListModel toDoList);

}
