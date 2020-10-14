package ObserverInterfaces;

import Models.ToDoLists;

public interface ToDoListRemoveObserver {

    void update(ToDoLists toDoList, ToDoListRemoveObservable o);
}
