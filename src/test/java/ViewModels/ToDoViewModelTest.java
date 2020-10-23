package ViewModels;

import Models.ToDoListModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class ToDoViewModelTest {


    @Test
    void addToDoLists() {
        String string = "Handlarlista";
        String description = "Handla på Willys på fredag";
        ArrayList<String> arrayListTimeAndDeadline = new ArrayList<>();
        ArrayList<String> checkboxes = new ArrayList<>();
        ArrayList<String> checklists = new ArrayList<>();

        arrayListTimeAndDeadline.add("11");
        arrayListTimeAndDeadline.add("11");
        arrayListTimeAndDeadline.add("11");
        arrayListTimeAndDeadline.add("11");

        checklists.add("tomat");
        checkboxes.add("notClicked");

        ArrayList<ToDoListModel> arrayListToDoList = new ArrayList<>();
        ToDoListModel toDoList = new ToDoListModel(string, description, arrayListTimeAndDeadline, checklists, checkboxes);

        arrayListToDoList.add(toDoList);
        assertEquals (1, arrayListToDoList.size());
    }



}