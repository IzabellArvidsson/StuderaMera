package ViewModels;

import Models.ToDoListModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class ToDoViewModelTest {

    final static String string = "Handlarlista";
    final static String description = "Handla på Willys på fredag";

    @Test
    void addToDoLists() {
        final List<String> arrayListTimeAndDeadline = new ArrayList<>();
        final List<String> checkboxes = new ArrayList<>();
        final List<String> checklists = new ArrayList<>();

        arrayListTimeAndDeadline.add("11");
        arrayListTimeAndDeadline.add("11");
        arrayListTimeAndDeadline.add("11");
        arrayListTimeAndDeadline.add("11");

        checklists.add("tomat");
        checkboxes.add("notClicked");

        final List<ToDoListModel> arrayListToDoList = new ArrayList<>();
        final ToDoListModel toDoList = new ToDoListModel(string, description, arrayListTimeAndDeadline, checklists, checkboxes);

        arrayListToDoList.add(toDoList);
        assertEquals (1, arrayListToDoList.size());
    }
}