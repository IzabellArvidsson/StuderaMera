package ViewModels;

import Models.ToDoLists;
import ViewControllers.listInToDoController;
import javafx.scene.layout.FlowPane;
import java.io.*;
import java.util.ArrayList;


public class ToDoViewModel {

    private static ArrayList<ToDoLists> allToDoLists = new ArrayList<>();

     public static void addToDoLists(String nameTextField, ArrayList<String> checklist, FlowPane toDoListFlowPane){
        ToDoLists toDoLists = new ToDoLists(nameTextField, checkListEmpty(checklist));
        toDoListFlowPane.getChildren().add(new listInToDoController(toDoLists));
        addToDoList(toDoLists);
        ToDoListHandler.saveToDoList(allToDoLists);
    }
    
    private static ArrayList<String> checkListEmpty(ArrayList<String> checklist){
        ArrayList<String> noEmptyChecklist = new ArrayList<>();
        for (String string: checklist) {
            if(!string.equals("")){
                noEmptyChecklist.add(string);
            }
        }
        return noEmptyChecklist;
    }

    private static void addToDoList(ToDoLists toDoLists){
        allToDoLists.add(toDoLists);
    }

}