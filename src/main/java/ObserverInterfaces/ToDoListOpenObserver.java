package ObserverInterfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * Uses: ToDoListModel
 * Used by: ToDoListView by implementation
 *
 * Author: Julia
 */

public interface ToDoListOpenObserver {
    void updateOpen(String name, String description, List<String > timeAndDeadline, List<String> checklists,
                    List<String>  checkboxes);

}
