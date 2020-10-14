package ViewControllers;

import Models.ToDoLists;
import ObserverInterfaces.ToDoListOpenObservable;
import ObserverInterfaces.ToDoListOpenObserver;
import ObserverInterfaces.ToDoListRemoveObservable;
import ObserverInterfaces.ToDoListRemoveObserver;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.ArrayList;

public class listInToDoController extends AnchorPane implements ToDoListRemoveObservable, ToDoListOpenObservable {

    @FXML  Text nameText;
    @FXML  Text numberOfChecklistsText;
    @FXML  Button deleteButton;
    ToDoLists toDoList;

    ArrayList<ToDoListRemoveObserver> observerArrayList = new ArrayList<>();
    ArrayList<ToDoListOpenObserver> openObserverArrayList = new ArrayList<>();


    public listInToDoController(ToDoLists toDoLists){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml_files/listInToDo.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        nameText.setText(toDoLists.getName());
        numberOfChecklistsText.setText("0/" + toDoLists.getNOfChecklists());
        toDoList = toDoLists;
    }

    @FXML
    private void onDeleteButtonClick(){
        notifyObservers();
    }

    @Override
    public void add(ToDoListRemoveObserver o) {
        observerArrayList.add(o);
    }

    @Override
    public void addOpen(ToDoListOpenObserver o) {
        openObserverArrayList.add(o);
    }

    @Override
    public void notifyOpenObservers() {
        for (ToDoListOpenObserver o: openObserverArrayList) {
            o.updateOpen(toDoList);
        }
    }

    @Override
    public void notifyObservers() {
        for (ToDoListRemoveObserver o: observerArrayList) {
            o.update(toDoList,this);
        }
    }
    @FXML
    private void onTodoListClicked(){
        notifyOpenObservers();
    }
}
