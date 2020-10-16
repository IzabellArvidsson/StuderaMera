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
        ArrayList<String> arrayListString = new ArrayList<>();
        arrayListString.add("11");
        arrayListString.add("11");
        arrayListString.add("11");
        arrayListString.add("11");

        ArrayList<ToDoListModel> arrayListToDoList = new ArrayList<>();
        ToDoListModel toDoList = new ToDoListModel(string, description, arrayListString);

        arrayListToDoList.add(toDoList);
        assertEquals (1, arrayListToDoList.size());
    }

}