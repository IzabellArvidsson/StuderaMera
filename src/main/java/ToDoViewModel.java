import ObserverInterfaces.ToDoObservable;
import ObserverInterfaces.ToDoObserver;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

public class ToDoViewModel implements ToDoObservable {

    private ArrayList<ToDoLists> allToDoLists = new ArrayList<>();





    void addToDoLists(String nameTextField, ArrayList<TextField> checklist, FlowPane toDoListFlowPane){
        ToDoLists toDoLists = new ToDoLists(nameTextField, checkListEmpty(checklist));
        toDoListFlowPane.getChildren().add(new listInToDoController(toDoLists));
        addToDoList(toDoLists);
    }
    
    private ArrayList<TextField> checkListEmpty(ArrayList<TextField> checklist){
        ArrayList<TextField> noEmptyChecklist = new ArrayList<>();
        for (TextField textField: checklist) {
            if(!textField.getText().equals("")){
                noEmptyChecklist.add(textField);
            }
        }
        return noEmptyChecklist;
    }

    private ArrayList<ToDoLists> addToDoList(ToDoLists toDoLists){
        allToDoLists.add(toDoLists);

        return allToDoLists;
    }

    public ArrayList<ToDoLists> getAllToDoLists() {
        return allToDoLists;
    }



    @Override
    public void addObserver(ToDoObserver toDoObserver) {

    }

    @Override
    public void notifyObserver() {

    }
}
