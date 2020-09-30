import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;

public class ToDoViewModel implements ToDoObservable{


    void addToDoLists(String nameTextField, int checklist, FlowPane toDoListFlowPane){
        ToDoLists toDoLists = new ToDoLists(nameTextField, checklist);
        toDoListFlowPane.getChildren().add(new listInToDoController(toDoLists));
    }




    @Override
    public void addObserver(ToDoObserver toDoObserver) {

    }

    @Override
    public void notifyObserver() {

    }
}
