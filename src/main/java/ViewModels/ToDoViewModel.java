package ViewModels;

import Models.ToDoLists;
import ViewControllers.listInToDoController;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import java.util.ArrayList;


public class ToDoViewModel {

    private static ArrayList<ToDoLists> allToDoLists = new ArrayList<>();

     public static void addToDoLists(String nameTextField, ArrayList<TextField> checklist, FlowPane toDoListFlowPane, String id){
         ToDoLists toDoLists = new ToDoLists(nameTextField);

        if(id.equals("handler")){
            toDoLists.setChecklists(checklist);
        }
        else{
            toDoLists.setChecklists(checkListEmpty(checklist));
        }
        toDoListFlowPane.getChildren().add(new listInToDoController(toDoLists));
        addToDoList(toDoLists);
        ToDoListHandler.saveToDoList(allToDoLists);
    }
    
    private static ArrayList<String> checkListEmpty(ArrayList<TextField> checklist){
        ArrayList<String> noEmptyChecklist = new ArrayList<>();
        for (TextField textField: checklist) {
            if(!textField.getText().equals("")){
                noEmptyChecklist.add(textField.getText());
            }
        }
        return noEmptyChecklist;
    }

    private static void addToDoList(ToDoLists toDoLists){
        allToDoLists.add(toDoLists);
    }

}