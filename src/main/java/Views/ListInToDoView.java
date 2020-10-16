package Views;

import Models.ToDoListModel;
import ObserverInterfaces.ToDoListOpenObservable;
import ObserverInterfaces.ToDoListOpenObserver;
import ObserverInterfaces.ToDoListRemoveObservable;
import ObserverInterfaces.ToDoListRemoveObserver;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.ArrayList;

public class ListInToDoView extends AnchorPane implements ToDoListRemoveObservable, ToDoListOpenObservable {

    @FXML  Text nameText;
    @FXML  Text numberOfChecklistsText;
    ToDoListModel toDoList;

    ArrayList<ToDoListRemoveObserver> observerArrayList = new ArrayList<>();
    ArrayList<ToDoListOpenObserver> openObserverArrayList = new ArrayList<>();

    /**
     * This method
     *
     * @param toDoListModel
     */

    public ListInToDoView(ToDoListModel toDoListModel){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml_files/listInToDo.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        nameText.setText(toDoListModel.getName());
        numberOfChecklistsText.setText(toDoListModel.getNOfCheckboxesClicked() + "/" + toDoListModel.getNOfChecklists());
        toDoList = toDoListModel;
    }

    /**
     * This method calls on another method, which notify observers, when someone clicks on the delete button
     */

    @FXML
    private void onDeleteButtonClick(){ notifyObservers(); }

    /**
     * This method calls on another method, which notify observers, when someone clicks on the listInToDo
     */

    @FXML
    private void onTodoListClicked(){
        notifyOpenObservers();}

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
}
