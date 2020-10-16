package ObserverInterfaces;

import Models.ToDoListModel;

public interface ToDoListRemoveObserver {

    void update(ToDoListModel toDoList, ToDoListRemoveObservable o);
}
