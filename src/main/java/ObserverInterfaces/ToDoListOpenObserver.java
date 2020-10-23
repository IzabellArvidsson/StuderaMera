package ObserverInterfaces;

import java.util.ArrayList;

/**
 * Uses: ToDoListModel
 * Used by: ToDoListView by implementation
 *
 * Author: Julia
 */

public interface ToDoListOpenObserver {
    void updateOpen(String name, String description, ArrayList<String > timeAndDeadline, ArrayList<String> checklists,
                    ArrayList<String>  checkboxes);

}
